#!/usr/bin/env bash
cp ./garage-mvc/target/*.war ./ops/container/
cd ./ops/container/
docker build -t garage-mvc -f Dockerfile_mvc .
rm *.war

#start container
docker run garage-mvc