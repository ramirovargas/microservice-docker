FROM openjdk
MAINTAINER Ramiro Vargas <ramiro.vargassalas@gmail.com>
ADD target/containerized-main-0.0.1-SNAPSHOT.jar containerized-main.jar
ENTRYPOINT ["java", "-jar", "/containerized-main.jar"]
EXPOSE 2222
