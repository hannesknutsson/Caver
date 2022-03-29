FROM openjdk:slim
COPY target/caver*.jar caver.jar
CMD ["java", "-jar", "caver.jar"]