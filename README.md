Connecting Microservices with OpenFeign and Eureka Service Registry

Introduction
This repository demonstrates how to connect multiple microservices using OpenFeign for communication and Eureka Service Registry for service discovery in a Spring Boot application. Additionally, it includes an API Gateway implemented with Spring Cloud Gateway.

Technologies Used
Java
Spring Boot
Spring Cloud
OpenFeign
Eureka Service Registry
Spring Cloud Gateway

Setup
1. Microservice Setup
Create your microservices. For demonstration purposes, let's assume you have two microservices: microservice1 and microservice2.
2. OpenFeign Configuration
Create Feign clients in each microservice to communicate with other microservices.
Define interfaces annotated with @FeignClient for each microservice you want to communicate with.
3. Eureka Service Registry
Set up the Eureka server to act as a service registry.
Configure each microservice to register with the Eureka server.
4. Service Gateway API
Create a new Spring Boot project for the Service Gateway API.
Configure the Service Gateway to use Eureka for service discovery.
Implement endpoint mappings to route requests to appropriate microservices using OpenFeign clients.
5. Build and Run
Build each microservice and start the Eureka server and Service Gateway API.

Usage
Access the Service Gateway API through its defined endpoints.
The Service Gateway API will route requests to the appropriate microservices based on the endpoint mappings.

Conclusion
By following this setup, you can effectively connect multiple microservices using OpenFeign for communication and Eureka for service registration and discovery. The Service Gateway API acts as a centralized entry point for all incoming requests, simplifying the overall architecture and providing a cohesive interface for clients.
