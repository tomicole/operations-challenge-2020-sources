# Campspot DevOps Challenge Application Sources

This repository contains the sources for a simple client-server web application. The server portion is a Kotlin web application using the Dropwizard framework (dropwizard.io). The client is a very simple HTML and JavaScript application.

## Build/run Dependencies
 - Java 8
 - Maven
 - Redis

## Building and running the server app
 1. Install all dependencies (see above)
 1. Run `mvn package` to build the application JAR
 1. After this succeeds, you should be able to find the JAR at `devops-challenge-web-service/target/devops-challenge-web-service-1.0-SNAPSHOT.jar`
 1. Run the app with the following command `java -jar devops-challenge-web-service/target/devops-challenge-web-service-1.0-SNAPSHOT.jar server devops-challenge-web-service/config.yml`
 1. After running he above, the app should be available on ports 8888 and 8889
