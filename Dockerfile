FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} review.jar
ENTRYPOINT ["java", "-jar", "/review.jar"]
EXPOSE 8080