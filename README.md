# 🛒 E-Commerce Microservices Backend (Java + Spring Boot)

This project is a simple e-commerce backend system built using Java Spring Boot and microservices architecture. The goal is to learn how to build secure and scalable systems using modern patterns and tools.



## 🔧 Tech Stack

- Java 17
- Spring Boot
- Spring Cloud (Eureka, Gateway)
- Spring Security + JWT
- MySQL



## 📦 Microservices

| Service | Port | Description |
|--------|------|-------------|
| Discovery Server | `8761` | Service discovery |
| User Service | `8081` | Registration, login, profile |
| Product Service | `8082` | Products, categories |
| Payment Service | `8083` | Payment transactions, payment history |
| Inventory Service | `8084` | Inventory Stock |
| Order Service | `8085` | Order placement, order history |



## 🧠 Architecture
The project is build using microservices architecture

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
