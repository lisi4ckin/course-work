FROM bellsoft/liberica-openjdk-debian:18-37
FROM maven:3.8.3-openjdk-17 as maven_build
LABEL authors="alisitsin"

WORKDIR /app

COPY target/fish-club-server-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8896

ENTRYPOINT ["java", "-jar", "app.jar"]