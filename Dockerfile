FROM openjdk:8-jdk-alpine

COPY build/libs/openclassrooms_9th-project_note-microservice-0.0.1-SNAPSHOT.jar /Note.jar

CMD ["java", "-jar", "/Note.jar"]
