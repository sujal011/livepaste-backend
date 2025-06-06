# Build stage
FROM maven:3.9.9-eclipse-temurin-21-alpine AS build

# Set working directory
WORKDIR /app

# Copy pom.xml first to leverage Docker cache
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy the rest of the application code
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Run stage
FROM openjdk:21-slim

# Set working directory
WORKDIR /app

# Copy the built artifact from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the application port
EXPOSE 80

# Set the entrypoint
ENTRYPOINT ["sh", "-c", "java -jar app.jar"] 