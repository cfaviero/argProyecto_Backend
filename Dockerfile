FROM amazoncorretto:18-alpine-jdk
MAINTAINER cfaviero
COPY target/demo-0.0.1-SNAPSHOT.jar  demo-app.jar
ENTRYPOINT ["java","-jar","/demo-app.jar"]