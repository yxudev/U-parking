Created by Yishan, version 1.0

Uparking-Microservice
=======================
A simple SpringMVC Rest project

## To run locally
This SpringMVC microservice is driven using Maven. To download and run locally simply execute the following from the command line:

> git clone https://github.com/yxu1234/javaplus.git

To run this project, **_Docker is highly recommended_**! ~~Otherwise, good luck!~~

If you choose Docker, to make sure the program running smoothly, please use docker maven and select the 3.6-jdk-8 version.

##### Local env

Use official postgres docker image to create a postgres database server:

>docker pull postgres

>ocker run --name UParkingDemo -e POSTGRES_DB=${databaseName} -e POSTGRES_USER=${username} -e POSTGRES_PASSWORD=${password} -p 5432:5432 -d postgres

This will create the database server on port 5432 by default. You are welcomed to adjust host-port as well as container-port to your desired ports by replacing **`5432:5432`**.

To create localhost databases, type:
> psql -h localhost -U admin -d postgres;
>create database u_parking_unit;

##### Schema migration

> mvn clean compile flyway:migrate -P unit -Ddb_url=localhost:5432/u_parking_unit -Ddb_password=${password} -Ddb_username=${username}

> mvn clean compile flyway:migrate -P test -Ddb_url=localhost:5432/u_parking_demo -Ddb_password=${password} -Ddb_username=${username}


## To run tests
Use the following command to execute the tests using Maven:
> mvn clean compile exec:java -Dspring.profiles.active=test -Ddb.url=localhost -Ddb.port=5432 -Ddb.dName=u_parking_demo -Ddb.username=${username} -Ddb.password=${password}


## To run inside a docker container
We can build, pacakge and run this microservice using Docker right out of the box. First we build the microservice locally by executing the following Maven command:

> mvn compile package -DskipTests=true && java -jar -Dspring.profiles.active=prod -Ddb.url=localhost -Ddb.port=5432 -Ddb.dName=u_parking_demo -Ddb.username=${username} -Ddb.password=${password} target/worker-0.1.0-SNAPSHOT.jar  

Now we have built the necessary artifacts, the next step is to build our docker image. From a terminal where you have access to Docker, execute the following command:

> docker build -t u_parking .

You can now run your dockerized microservice with the following command:

> docker run -name u_parking -i -t u_parking

## History
Originally created by _Yishan_ on 2019-04-01.
find internal ip : `docker inspect -f "{{ .NetworkSettings.IPAddress }}"`