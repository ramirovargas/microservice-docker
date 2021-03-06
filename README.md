# SPRING BOOT MICROCSERVICE USING SPRING CLOUD, EUREKA, RIBBON, ZUUL

This project is created to get experience on **Microservices With Netflix OSS**. This is a simple project by coded imperative programming with simple business requirements.

## There are four microservices:

- **Accounts** : This microservice is responsible for managing accounts. users.
- **Bills** : This microservice is responsible for managing products and the bills of them.
- **Logistic** : This microservice is responsible for manage orders create and get all orders
- **Backoffice**: This microservice is provides endpoints for backoffice ui is the principal endpoint.

Backoffice microservice has an endpoint with path ``` /api/v1/backoffice/orders ``` . This endpoint return a list of orders with name of product and account. It connects accounts, products and orders 
microservices via **Feign**.
And the ``` /api/v1/backoffice/checkout ```. endpoint as the requirement ask. connect microservices via **feign** 

## Build & Run docker compose

- *>mvn clean package* : to build
- *>docker-compose up* --build : build docker images and containers and run containers
- *>docker-compose stop* : stop the dockerized services
- Each maven module has a Dockerfile

### EndPoints ###

Running by down here **Build & Run** to se this swagger urls

| Service       | Swwager                     | 
| ------------- | ----------------------------- | 
| Accounts      |   http://localhost:7500/swagger-ui.html#/account-resource      | 
| Logistic      |   http://localhost:7502/swagger-ui.html#/order-resource           | 
| Bills      |   http://localhost:7501/swagger-ui.html#/product-resource      |   


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
| Backoffice    | **/backoffice**/api/v1/backoffice/checkout **POST**  |

JSON example for POST

```
{
     "id": 10,
     "accountId": 1,
     "date": "2020-06-29T15:46:50.484+0000",
     "direction": "Calle 123",
     "products": [
         {
             "id": 1,
             "name": "Camara",
             "price": 100.0,
             "quantity": 3
         },
         {
             "id": 2,
             "name": "Tv",
             "price": 5.0,
             "quantity": 2
         },
         {
             "id": 3,
             "name": "Computador",
             "price": 200.0,
             "quantity": 2
         },
         {
             "id": 4,
             "name": "Celular",
             "price": 50.0,
             "quantity": 1
         }
     ]
 } 
``` 
## the first time to try /backoffice try many times if doesn't work there could be some timeout
URI for gateway : *http://localhost:8762*


## Used Netflix OSS:

- **Netflix Eureka** is used for discovery service.
- **Netflix Ribbon** is used for client side load-balancing.
- **Netflix Zuul** is used for gateway.

In docker-compose.yml file:

- Accounts Service : **__2222__** port is mapped to **__7500__** port of host
- Bills Service : **__2222__** port is mapped to **__7501__** port of host
- Logistic Service : **__2222__** port is mapped to **__7502__** port of host
- Backoffice Service : **__2222__** port is mapped to **__7503__** port of host
- Eureka Discovery Service : **__8761__** port is mapped to **__8761__** port of host
- Zuul Gateway Service : **__8762__** port is mapped to **__8762__** port of host

## Aspects to improve
* There is shared information that is repeated as the products, when you have a database it is solved
* Given the time worked on the entities of the services, the ideal would be to create DTO for each manipulation and services.
* Swagger documentation to the main server the service that maps to swwager doesnt obtain the information of the main API
* Zuul sometimes is late in starting and we need to make several request to work properly

## Aspects that were taken into account
* Have the discovery service for each service
* have the main service main and connected with **feign** to get the other services
* Service are the way thar netflix oss is recommended
