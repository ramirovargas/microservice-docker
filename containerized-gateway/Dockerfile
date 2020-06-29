FROM openjdk
MAINTAINER Ramiro Vargas <ramiro.vargassalas@gmail.com>
ADD target/containerized-gateway-0.0.1-SNAPSHOT.jar containerized-gateway.jar
ENTRYPOINT ["java", "-jar", "/containerized-gateway.jar"]
EXPOSE 8761
