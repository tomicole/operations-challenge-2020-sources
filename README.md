# Campspot DevOps Challenge Application Sources

This repository contains the sources for a simple client-server web application. The server portion is a Kotlin web application using the Dropwizard framework (dropwizard.io). The client is a very simple HTML and JavaScript application. 

## Build/run Dependencies
 - Java 8
 - Maven
 - Redis

## Building and running the server app locally
 1. Install all dependencies (see above)
 1. Run `mvn package` to build the application JAR
 1. After this succeeds, you should be able to find the JAR at `devops-challenge-web-service/target/devops-challenge-web-service-1.0-SNAPSHOT.jar`
 1. Run the app with the following command `java -jar devops-challenge-web-service/target/devops-challenge-web-service-1.0-SNAPSHOT.jar server devops-challenge-web-service/config.yml`
 1. After running the above, the app should be available on ports 8888 and 8889. You may need to revise the code if you are not seeing the app or if you get any errors

## Deployment considerations 
You'll eventually want to be able to deploy this through a pipeline into the AWS cloud, so you may want to consider what additional tooling you may need to achieve that.

## Extra Credit
The server exposes a public API on port 8888 by default, and an admin API on port 8889. The client makes use of the `/healthcheck` endpoint on port 8889 in addition to the public API, but should not have access to the other resources on the admin port.

## Challenge next steps
Create a repository for your challenge project. Share this repository with your interview coordinator so that it can be shared with the DevOps team ahead of your tech interview
