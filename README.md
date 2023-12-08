# Serverless AWS Web Service
A boilerplate java project for a serverless web service deployed on AWS.

## Deployment
### Local Deployment
1) Build the package `mvn clean package`
2) Package the CloudFormation stack
```
aws cloudformation package --template-file ./configuration/stack.yaml \
    --s3-bucket <bucket name> \
    --output-template-file ./target/packaged.stack.yaml
```
3) Deploy the CloudFormation stack
```
aws cloudformation deploy --template-file ./target/packaged.stack.yml \
  --capabilities "CAPABILITY_NAMED_IAM" \
  --stack-name "<alias|'desktop'>-WebService" \
  --parameter-overrides "Stage=<alias|'desktop'>"
```

## Appendix
[AWS API Gateway](https://aws.amazon.com/api-gateway/)

[AWS Lambda](https://aws.amazon.com/lambda/)

[Lombok](https://projectlombok.org/)
