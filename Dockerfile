FROM openjdk:8-jdk-alpine

WORKDIR /usr/app

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} bin/football.jar

CMD ["java","-jar", "./bin/football.jar"]