# Use Maven with Java 17
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn clean install -DskipTests -q

# Copy the rest of the source code
COPY src src

# Build the Spring Boot application
RUN mvn package -DskipTests

# Use a lightweight JDK runtime
FROM eclipse-temurin:17-jre
WORKDIR /app

# Expose the application port
EXPOSE 8080

# Copy the built JAR file
COPY --from=build /app/target/*.jar app.jar

# Run the application
CMD ["java", "-jar", "app.jar"]
