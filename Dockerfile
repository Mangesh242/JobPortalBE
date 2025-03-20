FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/*.jar
WORKDIR /laborm
COPY ${JAR_FILE} laborm/app.jar
ENTRYPOINT ["java","-jar","laborm/app.jar"]