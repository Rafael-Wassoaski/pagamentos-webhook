FROM maven:3.8.5-openjdk-17 as builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src/ ./src/
RUN mvn clean package -DskipTests=true

FROM eclipse-temurin:17-jdk-alpine as prod
USER root
RUN mkdir /app
COPY --from=builder /app/target/*.jar /app/app.jar
COPY src/main/resources/application.properties /app/application.properties

WORKDIR /app
EXPOSE 8082
ENTRYPOINT ["java","-jar","/app/app.jar", "--spring.config.location=/app/application.properties"]