FROM openjdk:21-jdk-slim AS build

RUN apt-get update && apt-get install -y maven curl && rm -rf /var/lib/apt/lists/*

WORKDIR /app

COPY pom.xml ./
RUN mvn dependency:go-offline

COPY . ./
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim

WORKDIR /app

COPY --from=build /app/target/*.jar /app/app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]

