# Customer REST API with MYSQL
Spring Web API Framework
use to test Docker and Kubernetes Microservices 

Example solution:



````
                         ---------------
                          Web Page HTML
                             (link)
                         ---------------
                                |
                                | 
                    ----------------------------
                    Load balancer port 80:8080 
                    ----------------------------
                       |                   |
    --------------------------      --------------------------
      Customer-API Port 8080          Customer-API Port 8080 
    --------------------------      --------------------------  
                      |              |
                    --------------------  
                           MYSQL DB
                    --------------------       

````
Create a Docker image for MYSQL:

````
docker build -t mysql-server-customer-api:xxx -f Dockerfile_MYSQL .
````

Launch a MYSQL deployment:

``````
docker run -d -p 3306:3306 --name mysql-server-customer-api mysql-server-customer-api:xxx
``````

Seed the database:

``````
docker exec -i mysql-server-customer-api sh -c 'exec mysql -uroot -p"$MYSQL_ROOT_PASSWORD"' < customer.sql
``````


Compile code run:

````
export MYSQL_DB_HOST=localhost
mvn clean install
(Be sure MYSQL is running)
````

Run the application on workstation:

````
java -jar customer-api-mysql-1.0.0.jar
````

Create a Docker image:

````
docker build -t customer-api-mysql:xxx .
````
Create a docker container from image: 

````
docker inspect mysql-server-customer-api | grep IPAddress
docker run -d -p 8080:8080 -e "MYSQL_DB_HOST=IPAddress" --name customer-api-mysql customer-api-mysql:xxx
````


Create a Kubernetes Deployment:

````
kubectl create -f customer-api-deployment.yml 
````
Create a Kubernetes Service:

````
kubectl create -f loadblancer-customer-api.yml
````




## Usage: 

Get all Customers:

````
GET /customer-api/v1/customers/all
````

Get Customer by id:

````
GET /customer-api/v1/customer/{id}
````

Add a Customer 

````
POST /customer-api/v1/customers

Header: application/json

    {
        "id": 3,
        "name": "John Doe",
        "title": "Manager",
        "department": "RMM"
    }


````
Update a Customer by id

````
PUT /customer-api/v1/customers/{id}

Header: application/json

    {
        "name": "John Doe",
        "title": "Manager",
        "department": "RMM"
    }
````
Delete a Customer by id


````
DELETE /customer-api/v1/customer/{id}
````

Search Customer name:

`````
GET  /customer-api/v1/customer/name/{name}
`````








