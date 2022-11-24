FROM openjdk:17-jdk-alpine as builder

WORKDIR /app

COPY ./pom.xml .
COPY ./.mvn ./.mvn
COPY ./mvnw .
COPY ./src ./src

RUN sed -i 's/\r$//' mvnw
RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /app
RUN mkdir ./logs

COPY --from=builder /app/target/bank-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

CMD ["java", "-jar", "bank-0.0.1-SNAPSHOT.jar"]


