# SPRING BOOT MICROCSERVICE USING SPRING CLOUD, EUREKA, RIBBON, ZUUL

This project is created to get experience on **Microservices With Netflix OSS**. This is a simple project by coded imperative programming with simple business requirements.

## There are four microservices:

- **Accounts** : This microservice is responsible for managing accounts. users.
- **Bills** : This microservice is responsible for managing products and the bills of them.
- **Logistic** : This microservice is responsible for manage orders create and get all orders
- **Backoffice**: This microservice is provides endpoints for backoffice ui is the principal endpoint.

Backoffice microservice has an endpoint with path "/api/v1/backoffice/orders". This endpoint return a list of orders with name of product and account. It connects accounts, products and orders 
microservices via **Feign**.

### EndPoints ###

para ejecutar los servicios localmente
* ejecutar mvn package en la raiz del proyecto
* ejecutar containerized-discovery
* cambiar en el servicio deseado en el archivo application.yaml defaultZone: http://discovery:8761/eureka/ por defaultZone: http://localhost:8761/eureka/

| Service       | Swwager                     | 
| ------------- | ----------------------------- | 
| Accounts      |   http://localhost:2222/swagger-ui.html#/account-resource      | 
| Logistic      |   http://localhost:2222/swagger-ui.html#/order-resource           | 
| Bills      |   http://localhost:2222/swagger-ui.html#/product-resource      |  
| BackOffice     |         | 

URI for gateway : *http://localhost:8762*

## Used Netflix OSS:

- **Netflix Eureka** is used for discovery service.
- **Netflix Ribbon** is used for client side load-balancing.
- **Netflix Zuul** is used for gateway.

## Build & Run

- *>mvn clean package* : to build
- *>docker-compose up* --build : build docker images and containers and run containers
- *>docker-compose stop* : stop the dockerized services
- Each maven module has a Dockerfile.

In docker-compose.yml file:

- Accounts Service : **__2222__** port is mapped to **__7500__** port of host
- Bills Service : **__2222__** port is mapped to **__7501__** port of host
- Logistic Service : **__2222__** port is mapped to **__7502__** port of host
- Backoffice Service : **__2222__** port is mapped to **__7503__** port of host
- Eureka Discovery Service : **__8761__** port is mapped to **__8761__** port of host
- Zuul Gateway Service : **__8762__** port is mapped to **__8762__** port of host 