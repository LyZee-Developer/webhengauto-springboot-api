# ===== Build stage =====
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app

# Copy Gradle wrapper and config first (for better cache)
COPY gradlew .
COPY gradle gradle
COPY build.gradle settings.gradle ./

# Download dependencies
RUN chmod +x gradlew && ./gradlew dependencies --no-daemon

# Copy source code
COPY src src

# Build Spring Boot jar
RUN ./gradlew clean bootJar --no-daemon


# ===== Runtime stage =====
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8989

ENTRYPOINT ["java", "-jar", "app.jar"]
