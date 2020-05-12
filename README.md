# Customer REST API with MYSQL
Spring Web API Framework
use to test Docker and Kubernetes Microservices 

Example solution:

index.html

 ![Index.html](webindex.png)


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





Compile code run:

````
mvn clean install
````

Run the application on workstation:

````
java -jar customer-api-xxx.jar
````

Create a Docker image:

````
docker build -t customer-api:xxx .
````
Create a docker container from image: 

````
docker run -d -p 8080:8080 --name customer-api customer-api:xxx
````

Create a Docker image for MYSQL:

````
docker build -t mysqlserver:1 -f Dockerfile_MYSQL .
````

Launch a MYSQL deployment:

``````
docker run -d -p 3306:3306 --name mysqltest mysqlserver:1
``````

Seed the database:

``````
docker exec -i mysqltest sh -c 'exec mysql -uroot -p"$MYSQL_ROOT_PASSWORD"' < customer.sql
``````




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
GETT /customer-api/v1/customer/{id}
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








