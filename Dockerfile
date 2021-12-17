FROM gradle:7.3.1-jdk11-alpine AS project-build

WORKDIR /app

COPY build.gradle /app

RUN gradle build || return 0

COPY . .

RUN gradle clean build

# step 2
FROM openjdk:11-jre-buster

WORKDIR /app

COPY --from=project-build /app/build/libs/playground-1.0-SNAPSHOT.jar playground.jar

ARG ADDITIONAL_OPTS

ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

SHELL ["/bin/sh", "-c"]

EXPOSE 9000
EXPOSE 5005

CMD java ${ADDITIONAL_OPTS} -jar playground.jar