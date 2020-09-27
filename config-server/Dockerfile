#### Stage 1: Build the application
FROM maven:3.5-jdk-8 as maven

# Set the current working directory inside the image
WORKDIR /config-server

# Copy maven executable to the image
COPY mvnw .
COPY .mvn .mvn

# Copy the pom.xml file
COPY pom.xml .

# Build all the dependencies in preparation to go offline. 
# This is a separate step so the dependencies will be cached unless 
# the pom.xml file has changed.
RUN chmod +x ./mvnw
RUN ./mvnw dependency:go-offline -B

# Copy the project source
COPY src src

# Package the application
RUN ./mvnw package -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

#### Stage 2: A minimal docker image with command to run the app 
FROM openjdk:8-jre-alpine

ARG DEPENDENCY=/config-server/target/dependency

# Copy project dependencies from the build stage
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /config-server/lib
COPY --from=build ${DEPENDENCY}/META-INF /config-server/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /config-server

ENTRYPOINT ["java","-cp","config-server:config-server/lib/*","com.imm.server.ConfigServerApplication"]
