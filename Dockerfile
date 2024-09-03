FROM eclipse-temurin:21 AS build

WORKDIR /app/build

COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .
RUN chmod +x mvnw

RUN ./mvnw dependency:go-offline

COPY src src

RUN ./mvnw install -DskipTests

FROM eclipse-temurin:21

WORKDIR /app
COPY --from=build /app/build/target/*.jar app.jar

ENV PORT=8080
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]