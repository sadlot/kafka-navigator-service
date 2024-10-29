
FROM openjdk:24-slim-bullseye
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/navigator-service-1.0-SNAPSHOT.jar"]