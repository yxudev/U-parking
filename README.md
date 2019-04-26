Created by Yishan, version 1.0

Uparking-Microservice
=======================
A simple SpringMVC Rest project

## To run locally
This SpringMVC microservice is driven using Maven. To download and run locally simply execute the following from the command line:

> git clone https://github.com/yxu1234/javaplus.git

To run this project, **_Docker is highly recommended_**!

If you choose Docker, to make sure the program running smoothly, please use docker maven and select the 3.6-jdk-8 version(`jdk-8/Dockerfile`).

##### Local env

Use official postgres docker image to create a postgres database server:

> docker pull postgres

> docker run --name UParkingDemo -e POSTGRES_DB=${databaseName} -e POSTGRES_USER=${username} -e POSTGRES_PASSWORD=${password} -p 5432:5432 -d postgres

This will create the database server on port 5432 by default. You are welcomed to adjust host-port as well as container-port to your desired ports by replacing **`5432:5432`**.

To create localhost databases for unit tests, just type:
> psql -h localhost -U admin -d postgres;

>create database u_parking_unit;

##### Find IP address of container/database 
>docker inspect --format '{{ .NetworkSettings.IPAddress }}' UparkingDemo

##### Schema migration

Schema migration for creating tables in database for ${databaseName} environment on garage-mvc folder:
> mvn clean compile flyway:migrate -Dspring.profiles.active=${databaseName} -Ddatabase.serverName=${jdbc:postgresql://databaseUrl:databasePort/databaseName} -Ddatabase.username=${username} -Ddatabase.password=${password}

## To run tests
Use the following command to execute the tests using Maven:
> mvn test -Dspring.profiles.active=${databaseName} -Ddatabase.serverName=${jdbc:postgresql://databaseUrl:databasePort/databaseName} -Ddatabase.username=${username} -Ddatabase.password=${password} -Ddatabase.dataSourceClassName=org.postgresql.ds.PGSimpleDataSource -Daws.accessKeyId=${IAM ID from AWS} -Daws.secretKey=${IAM key from AWS} -Daws.region=us-east-1

## To run inside a docker container
We can build, pacakge and run this microservice using Docker right out of the box. First we build the microservice locally by executing the following Maven command:

> mvn compile package -DskipTests=true -Dspring.profiles.active=${databaseName}

Now we have built the necessary artifacts, the next step is to build our docker image. From a terminal where you have access to Docker, execute the following command to create docker file for MVC image as following template:

> FROM tomcat:9.0.16-jre8

> MAINTAINER Yishan Xu
  ARG APP_ENV=test
  ENV APP_ENV ${APP_ENV}

> EXPOSE 8080

> RUN rm -rf /usr/local/tomcat/webapps/ROOT
  COPY ./*.war /usr/local/tomcat/webapps/ROOT.war
  COPY ./setenv.${APP_ENV}.sh /usr/local/tomcat/bin/setenv.sh

You can now run your dockerized microservice with the following command:

> cp ./garage-mvc/target/*.war ./ops/container/
> cd ./ops/container/
> docker build -t garage-mvc -f Dockerfile_mvc .
> rm *.war

#start container
> docker run garage-mvc

## History
Originally created by _Yishan_ on 2019-04-01.
Updated by _Yishan_ on 2019-04-26. 
All rights reserved.