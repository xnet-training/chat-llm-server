ARG PORT=8080
FROM maven:3.6.3-openjdk-15 as BUILD

LABEL version=0.1.0

COPY . /usr/src/app

RUN --mount=type=cache,target=/root/.m2 mvn --batch-mode -f /usr/src/app/pom.xml clean package
#RUN test $(find ./ -type f -name '*-api.jar' | wc -l) -eq 1

FROM amazoncorretto:17
ENV PORT ${PORT}
#ENV APP_PROFILE=kubernetes
#ENV APP_NAME=partyreferencedata
#ENV VAULT_SECRET=changeme
#ENV VAULT_URI=http://vault-service.management.svc.domain.local:8200

WORKDIR /usr/app
COPY --from=BUILD /usr/src/app/target/chat-server*.jar /usr/app/llm-server.jar

EXPOSE $PORT
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar","/usr/app/llm-server.jar"]
