FROM maven:3.8.4-openjdk-17-slim AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:17-slim

WORKDIR /app

COPY --from=build /app/target/wintersupplement-1.0-SNAPSHOT.jar app.jar

EXPOSE 1883

CMD ["java", "-jar", "app.jar"]
