#
# Build stage
#
FROM maven:3.8.6-jdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:17-jdk-slim
COPY --from=build /target/App3-0.0.1-SNAPSHOT.jar App3.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","App3.jar"]