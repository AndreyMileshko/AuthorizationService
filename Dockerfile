FROM openjdk:17-jdk-alpine

EXPOSE 8080

COPY build/libs/AuthorizationService-0.0.1-SNAPSHOT.jar authorizationService.jar

CMD ["java", "-jar", "authorizationService.jar"]