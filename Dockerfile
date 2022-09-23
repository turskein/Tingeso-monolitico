FROM openjdk:11
EXPOSE 8091
RUN mkdir -p /app/
ADD build/libs/proyecto-0.0.1-SNAPSHOT.jar /app/proyecto-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/proyecto-0.0.1-SNAPSHOT.jar"]