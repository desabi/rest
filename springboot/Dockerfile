FROM openjdk:8-jdk-alpine
EXPOSE 8899
ARG JAR_FILE=target/springboot-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} springbootapp.jar
ENTRYPOINT ["java","-jar","/springbootapp.jar"]