#!/usr/bin/env bash
cp ../../garage-mvc/target/*.war ././

docker build -t garage-mvc -f Dockerfile_mvc .
rm *.war

#start container
#docker run garage-mvc
