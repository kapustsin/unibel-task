FROM amazoncorretto:17.0.8
RUN mkdir task
COPY /target/task-0.0.1-SNAPSHOT.war /task
WORKDIR task/
CMD ["java", "-jar", "task-0.0.1-SNAPSHOT.war"]