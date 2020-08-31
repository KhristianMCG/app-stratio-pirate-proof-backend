FROM openjdk:8-jdk-alpine

MAINTAINER Cristian Moreno - cristian.moreno@cmtekprojects.com

ADD /target/*.jar stratio-proof-pirates-backend.jar

ENTRYPOINT ["java","-jar","stratio-proof-pirates-backend.jar"]
