#Multi-Stage Build

# Stage 1: Build
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# install curl for healthcheck
RUN apk add --no-cache curl
COPY --from=build /app/target/DemoDevopsPractice-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080

# stage 3: Healthecheck for app
HEALTHCHECK --interval=30s --timeout=5s --retries=3 \
CMD curl -f http://localhost:8080 || exit 1

ENTRYPOINT ["java", "-jar", "app.jar"]