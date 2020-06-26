FROM openjdk:8-jdk-alpine
COPY target/developer-v1.jar developer-v1.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "developer-v1.jar"]
