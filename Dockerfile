# Baseimage, define from wich image I want to build from
FROM openjdk:8-jdk-alpine
# Get jar
ARG JAR_FILE=target/*.jar
# Copy jar
COPY ${JAR_FILE} app.jar
#
ENTRYPOINT ["java","-jar","/app.jar"]
