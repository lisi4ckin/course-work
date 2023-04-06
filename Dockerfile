FROM maven:3.8.3-openjdk-17 as maven_build
COPY . /build
WORKDIR /build
RUN mvn clean package -Dmaven.skip.test=true

FROM bellsoft/liberica-openjdk-alpine:17.0.6
WORKDIR /app
COPY --from=maven_build /build/target/fish-club-server-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8896
ENTRYPOINT ["java", "-jar", "app.jar"]