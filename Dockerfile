# Stage 1: Build the application with a Maven image that uses JDK 21
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean install -DskipTests

# Stage 2: Create a minimal runtime image with a JDK 21 JRE
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY --from=build /app/target/CodeLocker-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
# --- CHANGE THIS LINE ---
ENTRYPOINT ["java","-jar","app.jar"]