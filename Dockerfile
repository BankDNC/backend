FROM openjdk:17-jdk-alpine as builder

WORKDIR /app

COPY ./src ./src
COPY ./pom.xml .
COPY ./mvnw .
COPY ./.mvn ./.mvn

RUN ./mvnw clean package

FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=builder /app/target/bank-0.0.1-SNAPSHOT.jar .

ARG PORT_APP=8100
ENV PORT $PORT_APP

EXPOSE $PORT

CMD ["java", "-jar", "bank-0.0.1-SNAPSHOT.jar"]