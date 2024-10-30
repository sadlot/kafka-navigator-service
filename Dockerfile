# Use an official Maven image as the base image
FROM maven:3.9.9-ibm-semeru-23-jammy AS build
# Set the working directory in the container
WORKDIR /app
# Copy the pom.xml and the project files to the container
COPY pom.xml .
COPY src ./src
# Build the application using Maven
RUN mvn package spring-boot:repackage


# Use an official OpenJDK image as the base image
FROM openjdk:24-slim-bullseye
# Set the working directory in the container
WORKDIR /app
# Copy the built JAR file from the previous stage to the container
COPY --from=build /app/target/navigator-service-1.0-SNAPSHOT.jar navigator-service-1.0-SNAPSHOT.jar
# Set the command to run the application
CMD ["java", "-jar", "navigator-service-1.0-SNAPSHOT.jar"]