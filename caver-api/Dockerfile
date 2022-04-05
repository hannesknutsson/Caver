FROM openjdk:slim
COPY target/caver-api*.jar caver-api.jar
EXPOSE 80
CMD ["java", "-jar", "caver-api.jar"]