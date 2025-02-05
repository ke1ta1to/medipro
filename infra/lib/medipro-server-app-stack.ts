import { Construct } from "constructs";
import * as cdk from "aws-cdk-lib";
import * as certificatemanager from "aws-cdk-lib/aws-certificatemanager";
import * as cfn from "aws-cdk-lib/aws-cloudfront";
import * as cfn_origins from "aws-cdk-lib/aws-cloudfront-origins";
import * as ec2 from "aws-cdk-lib/aws-ec2";
import * as ecr from "aws-cdk-lib/aws-ecr";
import * as efs from "aws-cdk-lib/aws-efs";
import * as iam from "aws-cdk-lib/aws-iam";
import * as lambda from "aws-cdk-lib/aws-lambda";
import * as route53 from "aws-cdk-lib/aws-route53";
import * as route53_targets from "aws-cdk-lib/aws-route53-targets";

interface MediproServerAppStackProps extends cdk.StackProps {
  certificateArn: string;
  domainName: string;
}

export class MediproServerAppStack extends cdk.Stack {
  constructor(scope: Construct, id: string, props: MediproServerAppStackProps) {
    super(scope, id, props);

    const vpc = new ec2.Vpc(this, "MediproServerVpc", {
      subnetConfiguration: [
        {
          name: "Public",
          subnetType: ec2.SubnetType.PUBLIC,
          cidrMask: 24,
        },
      ],
    });

    const fileSystem = new efs.FileSystem(this, "MediproServerFileSystem", {
      vpc: vpc,
      vpcSubnets: { subnetType: ec2.SubnetType.PUBLIC },
      fileSystemPolicy: new iam.PolicyDocument({
        statements: [
          new iam.PolicyStatement({
            actions: ["elasticfilesystem:ClientMount"],
            principals: [new iam.AnyPrincipal()],
          }),
        ],
      }),
      removalPolicy: cdk.RemovalPolicy.DESTROY,
    });

    const accessPoint = new efs.AccessPoint(this, "MediproServerAccessPoint", {
      fileSystem: fileSystem,
      posixUser: {
        uid: "0",
        gid: "0",
      },
      createAcl: {
        ownerGid: "0",
        ownerUid: "0",
        permissions: "755",
      },
    });

    const repository = ecr.Repository.fromRepositoryName(
      this,
      "MediproServerRepository",
      "medipro-server",
    );

    const func = new lambda.DockerImageFunction(this, "MediproServerFunction", {
      code: lambda.DockerImageCode.fromEcr(repository, {
        tagOrDigest: "latest",
      }),
      vpc: vpc,
      vpcSubnets: { subnetType: ec2.SubnetType.PUBLIC },
      allowPublicSubnet: true,
      filesystem: lambda.FileSystem.fromEfsAccessPoint(
        accessPoint,
        "/mnt/data",
      ),
      environment: {
        DATABASE_URL: "jdbc:sqlite:/mnt/data/medipro.db",
      },
    });

    const funcUrl = func.addFunctionUrl({
      authType: lambda.FunctionUrlAuthType.AWS_IAM,
    });

    new cdk.CfnOutput(this, "MediproServerFunctionUrl", {
      value: funcUrl.url,
    });

    const instance = new ec2.Instance(this, "MediproServerInstance", {
      vpc: vpc,
      vpcSubnets: { subnetType: ec2.SubnetType.PUBLIC },
      instanceType: new ec2.InstanceType("t2.micro"),
      machineImage: ec2.MachineImage.latestAmazonLinux2023(),
      keyPair: ec2.KeyPair.fromKeyPairName(
        this,
        "MediproServerKeyPair",
        "m1mac",
      ),
    });
    instance.connections.allowFromAnyIpv4(ec2.Port.tcp(22));
    fileSystem.connections.allowDefaultPortFrom(instance);

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
