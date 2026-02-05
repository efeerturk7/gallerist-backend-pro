🏎️ Gallerist - Enterprise Automotive Management API
Gallerist is a production-ready RESTful API developed with Spring Boot 3.3.4, designed to handle automotive sales operations with high security and financial precision.

🌟 Project Overview
This project implements complex business rules, such as real-time currency conversion for sales, advanced security protocols, and optimized data retrieval patterns.

🚀 Key Features
Advanced Security: Stateless authentication utilizing JWT with Refresh Token Rotation.

Dynamic Pagination & Sorting: Integrated Spring Data JPA Pageable across Car, Customer, and Sales services for optimized performance.

Financial Engine: Integrated External Currency Rate API to manage car prices and customer balances in multiple currencies.

Clean Architecture: Strictly followed the Controller-Service-Repository pattern with DTO mapping.

Centralized Exception Handling: Standardized error responses via a global exception handler.

🛡️ Validation & Quality Assurance
Strict DTO Validation: Upgraded field-level security by replacing @NotNull with @NotBlank in DTO/IU classes to prevent empty string injections.

Request Integrity: Enforced API safety by adding @Valid annotations to all controller endpoints.

Unit Testing: Implemented comprehensive test suites using Mockito and JUnit 5 to validate business logic in findAllPageable services.

🛠️ Tech Stack
Language: Java 17

Framework: Spring Boot 3.3.4

Database: PostgreSQL

Security: Spring Security 6 & JJWT

Testing: Mockito & JUnit 5

Documentation: SpringDoc OpenAPI

📅 Roadmap
[x] Unit Testing: Business logic validation with Mockito.

[x] Pagination & Sorting: Optimized data retrieval.

[ ] Dockerization: Containerizing the application for seamless deployment.

📈 Getting Started
Clone the repository.

Configure your application.properties with PostgreSQL credentials.

Run mvn spring-boot:run.

Access Swagger UI: http://localhost:8080/swagger-ui/index.html
