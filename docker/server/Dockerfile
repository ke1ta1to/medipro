# syntax=docker/dockerfile:1
FROM public.ecr.aws/amazoncorretto/amazoncorretto:21
# FROM bitnami/java:21

WORKDIR /app

# Lambda Web Adapter
COPY --from=public.ecr.aws/awsguru/aws-lambda-adapter:0.5.0 /lambda-adapter /opt/extensions/lambda-adapter
ENV PORT=8000
ENV READINESS_CHECK_PATH=/v1

COPY ./src/net/keitaito/mediproserver ./src/net/keitaito/mediproserver
COPY ./lib ./lib

ENV CLASSPATH=/app/bin:/app/lib/*

# Javaのコンパイル
RUN javac -sourcepath ./src -d ./bin $(find . -name "*.java")

CMD [ "java", "-cp", "bin:lib/*", "net.keitaito.mediproserver.App" ]
