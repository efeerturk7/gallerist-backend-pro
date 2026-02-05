# 🏎️ Gallerist - Enterprise Automotive Management API

Gallerist is a production-ready RESTful API developed with **Spring Boot 3.3.4**, designed to handle automotive sales operations with high security and financial precision.

## 🌟 Project Overview
This project goes beyond basic CRUD operations by implementing complex business rules, such as real-time currency conversion for sales and advanced security protocols.

## 🚀 Key Features
* **Advanced Security:** Stateless authentication utilizing **JWT with Refresh Token Rotation**.
* **Financial Engine:** Integrated **External Currency Rate API** to manage car prices and customer balances in multiple currencies (USD/TRY).
* **Clean Architecture:** Strictly followed the Controller-Service-Repository pattern with DTO mapping to ensure scalability.
* **Centralized Exception Handling:** Custom global exception handler that returns standardized error responses.
* **API Documentation:** Fully interactive documentation via **Swagger UI (OpenAPI 3)**.

## 🛠️ Tech Stack
* **Language:** Java 17
* **Framework:** Spring Boot 3.3.4
* **Database:** PostgreSQL
* **Security:** Spring Security 6 & JJWT
* **Documentation:** SpringDoc OpenAPI

## 📅 Roadmap & Future Enhancements
This project is under active development. Upcoming features include:
* **[ ] Unit Testing:** Implementing comprehensive test suites using **Mockito** and JUnit 5 for business logic validation.
* **[ ] Pagination & Sorting:** Integrating **Spring Data JPA Pageable** for optimized data retrieval in large datasets.
* **[ ] Dockerization:** Containerizing the application and database for seamless deployment.

## 📈 Getting Started
1. Clone the repository.
2. Configure your `application.properties` with PostgreSQL credentials.
3. Run `mvn spring-boot:run`.
4. Access Swagger UI: `http://localhost:8080/swagger-ui/index.html`
