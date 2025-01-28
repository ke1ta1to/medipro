#!/usr/bin/env node
import * as cdk from "aws-cdk-lib";
import { MediproServerStack } from "../lib/medipro-server-stack";
import { MediproServerAppStack } from "../lib/medipro-server-app-stack";

const app = new cdk.App();
new MediproServerStack(app, "MediproServerStack", {
  repo: "eguchi1611/medipro",
});

new MediproServerAppStack(app, "MediproServerAppStack", {
  env: {
    account: process.env.CDK_DEFAULT_ACCOUNT,
    region: process.env.CDK_DEFAULT_REGION,
  },
  certificateArn:
    "arn:aws:acm:us-east-1:183295441800:certificate/8236b35e-4de2-463d-a9e9-be3539deb9b7",
  domainName: "api.medipro.keitaito.net",
});
