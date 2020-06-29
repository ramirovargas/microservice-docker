# SPRING BOOT MICROCSERVICE USING SPRING CLOUD, EUREKA, RIBBON, ZUUL

This project is created to get experience on **Microservices With Netflix OSS**. This is a simple project by coded imperative programming with simple business requirements.

## There are four microservices:

- **Accounts** : This microservice is responsible for managing accounts. users.
- **Bills** : This microservice is responsible for managing products and the bills of them.
- **Logistic** : This microservice is responsible for manage orders create and get all orders
- **Backoffice**: This microservice is provides endpoints for backoffice ui is the principal endpoint.

Backoffice microservice has an endpoint with path "/api/v1/backoffice/orders". This endpoint return a list of orders with name of product and account. It connects accounts, products and orders 
microservices via **Feign**.
And the "/api/v1/backoffice/checkout". endpoint as the requirement ask. connect microservices via **feign** 

### EndPoints ###


to run the services locally
* run mvn package at the root of the project
* run containerized-discovery
* change in the desired service in the application.yaml file defaultZone: http://discovery:8761/eureka/ by defaultZone:http://localhost:8761/eureka/

If yo run locally change the port to 2222

Running by **Build & Run** to se this swagger urls

| Service       | Swwager                     | 
| ------------- | ----------------------------- | 
| Accounts      |   http://localhost:7500/swagger-ui.html#/account-resource      | 
| Logistic      |   http://localhost:7502/swagger-ui.html#/order-resource           | 
| Bills      |   http://localhost:7501/swagger-ui.html#/product-resource      |  
| BackOffice     |         | 


### Gateways ###

| Service       | EndPoint                                  |
| ------------- | :---------------------------------------: |
| Accounts      | **/account**/api/v1/accounts/{id}         | 
| Accounts      | **/account**/api/v1/accounts              |
| Bills      | **/product**/api/v1/products/{id}         |
| Bills      | **/product**/api/v1/products              |
| Logistic        | **/order**/api/v1/orders/{id}             |
| Logistic        | **/order**/api/v1/orders                  |
| Backoffice    | **/backoffice**/api/v1/backoffice/orders  |

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

## Aspects to improve
* There is shared information that is repeated as the products, when you have a database it is solved
* Given the time worked on the entities of the services, the ideal would be to create DTO for each manipulation.
* Swagger documentation to the main server the service that maps to swwager doesnt obtain the information of the main API


## Aspects that were taken into account
* Have the discovery service for each service
* have the main service main and connected with **feign** to get the other services
* Logistic services were seen as order handlers, bill services were seen as product handlers, so endpoints with their names