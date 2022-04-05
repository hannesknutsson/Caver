FROM openjdk:slim
COPY target/caver-api*.jar caver-api.jar
EXPOSE 8080
CMD ["java", "-jar", "caver-api.jar"]