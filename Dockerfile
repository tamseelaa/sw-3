FROM maven:3.9.6-eclipse-temurin-17 AS build
LABEL authors="tamse"

WORKDIR /app

COPY pom.xml .
COPY . /app

RUN mvn package

CMD ["java", "-jar", "target/cal.jar"]