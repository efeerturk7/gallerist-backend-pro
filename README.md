# 🚗 Gallerist - Cloud-Native Car Gallery API

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green?style=for-the-badge&logo=springboot)
![Docker](https://img.shields.io/badge/Docker-Containerized-blue?style=for-the-badge&logo=docker)
![MySQL](https://img.shields.io/badge/MySQL-Aiven_Cloud-003545?style=for-the-badge&logo=mysql)
![Deployment](https://img.shields.io/badge/Deploy-Render-purple?style=for-the-badge&logo=render)

**Gallerist** is a robust, cloud-native Backend REST API designed to manage car gallery operations.

Built with **Spring Boot 3** and **Docker**, this project demonstrates a modern, secure, and scalable software architecture. It has been fully refactored to meet industry standards, containerized for portability, and deployed to a live cloud environment.

---

## 🔗 LIVE DEMO

The API is currently live and running on the cloud! You can test all endpoints directly via the interactive Swagger UI:

👉 **[CLICK HERE TO ACCESS LIVE SWAGGER UI](https://gallerist-backend-pro.onrender.com/swagger-ui/index.html)**

---

## 🚀 Major Refactoring Update (Feb 2026)

This project has undergone a significant architectural overhaul, migrating from a legacy local setup to a fully containerized cloud environment.

### 🛠 Key Technical Improvements

* **Cloud Migration (Render & Aiven):**
  * The application is containerized with **Docker** (Multi-Stage Build) and deployed on **Render**.
  * The database was migrated from local storage to a managed **MySQL** instance on **Aiven Cloud**, ensuring high availability and accessibility.

* **Clean Code & Architecture:**
  * **Dependency Injection:** Migrated from Field Injection (`@Autowired`) to **Constructor Injection** using Lombok's `@RequiredArgsConstructor`. This ensures immutability and testability.
  * **DTO Mapping:** Replaced reflection-based `BeanUtils` with **MapStruct** for type-safe, compile-time mapping generation.
  * **Fail-Fast Validation:** Implemented strict service-layer validations to prevent data integrity issues before they reach the database.

* **Security Enhancements:**
  * Implemented a stateless authentication mechanism using **JWT (JSON Web Tokens)**.
  * Refactored `SecurityFilterChain` to handle public (Swagger, Auth) and protected (Business Logic) endpoints efficiently.

---

## 🏗 System Architecture

The project follows a layered architecture with a focus on separation of concerns.

### 🐳 1. Docker & Containerization
- The application uses a **Multi-Stage Dockerfile** (Maven Build + OpenJDK Runtime) to create a lightweight and optimized production image.
- `docker-compose.yml` is configured for local development, orchestrating the app and database containers with a single command.

### ☁️ 2. Cloud-Native Database
- Unlike traditional setups, this project does not rely on a local database server.
- It connects securely to a **Managed MySQL Database** on Aiven, mimicking a real-world production environment.

### 🛡️ 3. Security Implementation
- **JWT Filters:** Custom filters intercept every request to validate tokens.
- **Role-Based Access:** The architecture supports scalable role-based authorization (e.g., Admin vs. User).

---

## 🛠️ Tech Stack

- **Language:** Java 21 (LTS)
- **Framework:** Spring Boot 3.2.x
- **Database:** MySQL (Aiven Cloud)
- **Containerization:** Docker & Docker Compose
- **Cloud Provider:** Render
- **Security:** Spring Security 6, JWT (JJWT)
- **Object Mapping:** MapStruct
- **Documentation:** OpenAPI / Swagger UI
- **Build Tool:** Maven

---

## ⚙️ How to Run Locally (Docker)

Since the project is fully Dockerized, you don't need to install Java or MySQL on your machine.

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/efeerturk7/gallerist-backend-pro.git](https://github.com/efeerturk7/gallerist-backend-pro.git)
   cd gallerist-backend-pro
Run with Docker Compose:

Bash
docker-compose up -d
This command will pull the necessary images and start the application on port 8081.

Access the API: Go to: http://localhost:8081/swagger-ui/index.html

🧪 Authentication Flow (How to Test)
The system is secured. To test protected endpoints (like adding a car or address), follow these steps in Swagger UI:

Register:

Go to Authentication Controller -> /rest/auth/register.

Create a new user.

Login:

Go to /rest/auth/login and enter your credentials.

Copy the accessToken from the response body (exclude the quotes).

Authorize:

Click the Authorize 🔓 button at the top right.

Paste the token (e.g., Bearer eyJhbGci...).

Click Authorize -> Close.

Success:

Now you can execute requests in Address Controller or Car Controller.

👨‍💻 Author
Bahadır Efe ERTÜRK - Backend Developer

LinkedIn Profile
https://www.linkedin.com/in/efeerturk7/

GitHub Profile
https://github.com/efeerturk7
