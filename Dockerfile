FROM openjdk:8-jdk-alpine

WORKDIR /ClusteredDataApp

COPY target/ClusteredDataApp.jar .
EXPOSE 8080

CMD ["java","-jar","ClusteredDataApp.jar"]