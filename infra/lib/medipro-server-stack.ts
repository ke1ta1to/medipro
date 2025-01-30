import * as cdk from "aws-cdk-lib";
import { Construct } from "constructs";
import * as ecr from "aws-cdk-lib/aws-ecr";
import * as iam from "aws-cdk-lib/aws-iam";

interface MediproServerStackProps extends cdk.StackProps {
  repo: string;
}

export class MediproServerStack extends cdk.Stack {
  constructor(scope: Construct, id: string, props: MediproServerStackProps) {
    super(scope, id, props);

    const repository = new ecr.Repository(this, "MediproServerRepository", {
      repositoryName: "medipro-server",
      removalPolicy: cdk.RemovalPolicy.DESTROY,
      emptyOnDelete: true,
    });

    const role = new iam.Role(this, "MediproServerEcrRole", {
      assumedBy: new iam.FederatedPrincipal(
        `arn:aws:iam::${this.account}:oidc-provider/token.actions.githubusercontent.com`,
        {
          StringLike: {
            "token.actions.githubusercontent.com:sub": `repo:${props.repo}:*`,
          },
          StringEquals: {
            "token.actions.githubusercontent.com:aud": "sts.amazonaws.com",
          },
        },
        "sts:AssumeRoleWithWebIdentity",
      ),
      roleName: "medipro-server-ecr-role",
    });
    role.addToPolicy(
      new iam.PolicyStatement({
        actions: ["ecr:GetAuthorizationToken"],
        resources: ["*"],
      }),
    );
    role.addToPolicy(
      new iam.PolicyStatement({
        actions: ["ecr:*"],
        resources: [repository.repositoryArn],
      }),
    );
  }
}
