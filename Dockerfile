FROM ubuntu:latest
LABEL authors="tamse"

WORKDIR /app

COPY pom.xml .
COPY . /app

RUN mvn package

CMD ["java", "-jar", "target/cal.jar"]