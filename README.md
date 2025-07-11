# 🛒 E-Commerce Microservices Backend (Java + Spring Boot)

This project is a simple e-commerce backend system built using Java Spring Boot and microservices architecture. The goal is to learn how to build secure and scalable systems using modern patterns and tools.

Refer the [Tasks Kanban Board](https://simplyankit.notion.site/22d3d25558a7808e83dec3f9683919ba?v=22d3d25558a7807091c3000cc21eca1d&source=copy_link)


## 🔧 Tech Stack

- Java 17
- Spring Boot 3
- Spring Cloud (Eureka, Gateway, Config)
- Spring Security + JWT
- Spring Data JPA
- MySQL (per service)
- Docker & Docker Compose
- Swagger/OpenAPI (API documentation)


## 📦 Microservices Overview

| Service        | Port  | Description                                  |
|----------------|-------|----------------------------------------------|
| User           | `8081`  | User registration, login, profile            |
| Product        | `8082`  | Product catalog, categories, prices          |
| Payment        | `8083`  | Payment processing (mock)                    |
| Inventory      | `8084`  | Stock management                             |
| Order          | `8085`  | Order processing, order status               |
| Cart           | `8086`  | Shopping cart management                     |
| API Gateway    | `8080`  | Request routing, authentication              |
| Eureka Server  | `8761`  | Service discovery                            |


## 💻 Project Structure
```markdown
/shoppit-api
├── user-service
│   ├── src
│   ├── pom.xml
│   └── application.properties
├── product-service
│   ├── src
│   ├── pom.xml
│   └── application.properties
├── order-service
│   ├── src
│   ├── pom.xml
│   └── application.properties
├── api-gateway
│   ├── src
│   ├── pom.xml
│   └── application.properties
├── discovery-server
│   ├── src
│   ├── pom.xml
│   └── application.properties
└── README.md
```

---

## 🏗️ Architecture Overview
The backend is composed of the following core microservices:
- **User Service**: Handles user registration, authentication (JWT), and profile management.
- **Product Catalog Service**: Manages product listings, categories, and prices.
- **Inventory Service**: Tracks and updates stock levels for products.
- **Cart Service**: Manages user shopping carts, including adding/removing items.
- **Order Service**: Processes orders and manages order status.
- **Payment Service**: Handles payment processing (mock implementation).
- **API Gateway**: Serves as a single entry point, routing requests and managing authentication.
- **Service Discovery**: Registers and locates services dynamically (Eureka).

## 🚀 Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/ak18dec/shoppit-api.git
cd shoppit-api
```


### 2. Build the Services

Each microservice is located in its own directory. You can build all services using Maven:

```bash
./mvnw clean install
```

### 3. Run with Docker Compose

Ensure Docker is installed and running.
```bash
docker-compose up --build
```
This will start all microservices, databases, Eureka server, and the API Gateway.
### 4. Access the Services

- **API Gateway**: `http://localhost:8080/`
- **Eureka Dashboard**: `http://localhost:8761/`
- **Swagger UI** (per service): e.g., `http://localhost:8087/swagger-ui.html`

## 🔐 Security

- **Authentication**: JWT tokens issued after login.
- **Authorization**: Role-based access control on endpoints.
- **API Gateway**: Centralized security and request validation.

## 📄 API Documentation

Each service exposes Swagger/OpenAPI documentation at `/swagger-ui.html`.

## 🧪 Testing

- Unit tests are included per service.
- Use tools like Postman or Swagger UI to manually test endpoints.

## 💡 Learning Goals

- Understand microservices architecture in Spring Boot.
- Implement service discovery, API gateway, and security.
- Containerize services with Docker.
- Practice inter-service communication and modular design.

## 🙋‍♂️ Author

- [Ankit Kumar](https://github.com/ak18dec)