FROM openjdk:17
WORKDIR /app
COPY ${JAR_FILE} app.jar
EXPOSE 3333
CMD ["java", "-jar", "Student_Management-0.0.1-SNAPSHOT.jar"]
