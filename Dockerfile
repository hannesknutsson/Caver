FROM openjdk:slim
COPY target/caver*.jar caver.jar
EXPOSE 80
CMD ["java", "-jar", "caver.jar"]