FROM simple4h/java8:v1.0
MAINTAINER simple4h
ARG workdir=/app
VOLUME ${workdir}
WORKDIR ${workdir}
ADD target/docker-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]