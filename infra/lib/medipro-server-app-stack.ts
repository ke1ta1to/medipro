import * as cdk from "aws-cdk-lib";
import { Construct } from "constructs";
import * as ecr from "aws-cdk-lib/aws-ecr";
import * as lambda from "aws-cdk-lib/aws-lambda";
import * as cfn from "aws-cdk-lib/aws-cloudfront";
import * as cfn_origins from "aws-cdk-lib/aws-cloudfront-origins";
import * as route53 from "aws-cdk-lib/aws-route53";
import * as route53_targets from "aws-cdk-lib/aws-route53-targets";
import * as certificatemanager from "aws-cdk-lib/aws-certificatemanager";

interface MediproServerAppStackProps extends cdk.StackProps {
  certificateArn: string;
  domainName: string;
}

export class MediproServerAppStack extends cdk.Stack {
  constructor(scope: Construct, id: string, props: MediproServerAppStackProps) {
    super(scope, id, props);

    const repository = ecr.Repository.fromRepositoryName(
      this,
      "MediproServerRepository",
      "medipro-server",
    );

    const func = new lambda.DockerImageFunction(this, "MediproServerFunction", {
      code: lambda.DockerImageCode.fromEcr(repository, {
        tagOrDigest: "latest",
      }),
    });

    const funcUrl = func.addFunctionUrl({
      authType: lambda.FunctionUrlAuthType.AWS_IAM,
    });

    new cdk.CfnOutput(this, "MediproServerFunctionUrl", {
      value: funcUrl.url,
    });

    const certificate = certificatemanager.Certificate.fromCertificateArn(
      this,
      "MediproServerCertificate",
      props.certificateArn,
    );

    const distribution = new cfn.Distribution(
      this,
      "MediproServerDistribution",
      {
        defaultBehavior: {
          origin:
            cfn_origins.FunctionUrlOrigin.withOriginAccessControl(funcUrl),
          viewerProtocolPolicy: cfn.ViewerProtocolPolicy.REDIRECT_TO_HTTPS,
          cachePolicy: cfn.CachePolicy.CACHING_DISABLED,
          originRequestPolicy:
            cfn.OriginRequestPolicy.ALL_VIEWER_EXCEPT_HOST_HEADER,
          allowedMethods: cfn.AllowedMethods.ALLOW_ALL,
        },
        domainNames: [props.domainName],
        certificate: certificate,
      },
    );

    const hostedZone = route53.HostedZone.fromLookup(
      this,
      "MediproServerHostedZone",
      { domainName: "keitaito.net" },
    );

    new route53.ARecord(this, "MediproServerARecord", {
      zone: hostedZone,
      target: route53.RecordTarget.fromAlias(
        new route53_targets.CloudFrontTarget(distribution),
      ),
      recordName: props.domainName,
    });
  }
}
