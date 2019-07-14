FROM openjdk:8-jdk-alpine

COPY build/libs/planets-0.0.1-SNAPSHOT.jar /planets/app.jar

ENTRYPOINT ["usr/bin/java", "-jar", "/planets/app.jar"]