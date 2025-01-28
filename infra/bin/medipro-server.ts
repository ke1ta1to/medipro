#!/usr/bin/env node
import * as cdk from "aws-cdk-lib";
import { MediproServerStack } from "../lib/medipro-server-stack";

const app = new cdk.App();
new MediproServerStack(app, "MediproServerStack", {
  repo: "eguchi1611/medipro",
});
