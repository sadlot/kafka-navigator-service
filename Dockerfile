
FROM openjdk:24-slim-bullseye
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/navigator-service-1.0-SNAPSHOT.jar"]