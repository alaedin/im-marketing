FROM maven:3.6.3-jdk-8 as maven

ARG workspace.dir=discovery-service

WORKDIR /$workspace.dir

RUN cd /$workspace.dir

# copy the source tree and the pom.xml to our new container
COPY ./ /$workspace.dir
#COPY pom.xml /$workspace.dir

# fetch all dependencies
# RUN mvn dependency:go-offline -B