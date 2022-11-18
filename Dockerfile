FROM openjdk:8-jdk-alpine
MAINTAINER KTISYSTEMS
COPY target/rest-service-0.0.1-SNAPSHOT.jar rest-service-0.0.1.jar
ENTRYPOINT ["java","-jar","/rest-service-0.0.1.jar"]