# Stage 1: Build the application with Maven
FROM maven:3.8.5-openjdk-21 AS build
COPY . .
RUN mvn clean install -DskipTests

# Stage 2: Create a minimal runtime image
FROM openjdk:21.0.1-jdk-slim
COPY --from=build /target/CodeLocker-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]