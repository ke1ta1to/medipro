# syntax=docker/dockerfile:1
FROM public.ecr.aws/amazoncorretto/amazoncorretto:21 AS builder

WORKDIR /app

COPY ./src/net/keitaito/mediproserver ./src/net/keitaito/mediproserver

# Javaのコンパイル
RUN javac -sourcepath ./src -d ./classes $(find . -name "*.java")
RUN jar --create --verbose --file=./mediproserver.jar --main-class=net.keitaito.mediproserver.App -C ./classes .

FROM public.ecr.aws/amazoncorretto/amazoncorretto:21

WORKDIR /app

# Lambda Web Adapter
COPY --from=public.ecr.aws/awsguru/aws-lambda-adapter:0.5.0 /lambda-adapter /opt/extensions/lambda-adapter
ENV PORT=8000
ENV READINESS_CHECK_PATH=/api/v1

COPY --from=builder /app/mediproserver.jar .

CMD ["java", "-jar", "mediproserver.jar"]
