# 🚗 Gallerist - Car Gallery Management System
## 🚀 Refactoring Update (Feb 2026) - Architecture & Performance Overhaul

Major architectural improvements have been implemented to align the project with modern Spring Boot best practices. The codebase has been migrated from legacy patterns to a cleaner, type-safe, and more robust structure.

### 🛠 Key Technical Improvements

* **Dependency Injection Strategy:**
   * Migrated from Field Injection (`@Autowired`) to **Constructor Injection** using Lombok's `@RequiredArgsConstructor` and `private final` fields.
   * This ensures immutability, prevents `NullPointerException` at runtime, and improves testability.

* **DTO <-> Entity Mapping:**
   * Removed `BeanUtils` (reflection-based) to eliminate performance overhead and runtime errors.
   * Integrated **MapStruct** for type-safe, compile-time mapping generation.
   * Implemented specific `IU` (Insert/Update) DTOs to strictly control input data.

* **Service Layer Optimization:**
   * Refactored business logic to include strict validation (`findById` checks) before entity creation to prevent foreign key constraint violations.
   * Eliminated boilerplate code (manual setters/getters) and nested loops using Java Stream API.
   * Standardized return value handling for repository `save()` operations to ensure data consistency.

* **Clean Code Principles:**
   * Adopted "Fail Fast" approach for exception handling.
   * Improved readability and maintainability across all Service and Controller classes.

**Gallerist** is a robust, containerized Backend REST API designed to manage car gallery operations. This project demonstrates a modern, secure, and scalable software architecture using **Spring Boot** and **Docker**.

It has recently undergone a **major architectural refactoring** to ensure industry standards, including full Docker containerization, enhanced security protocols, and strict data validation layers.

---

## 🚀 Key Features & Architectural Improvements

This project is not just a CRUD application; it focuses on clean code principles and secure data handling.

### 🐳 1. Full Dockerization (Infrastructure as Code)
- The entire application (App + Database) is containerized using **Docker** and **Docker Compose**.
- **Zero-Configuration Setup:** No need to install Java or PostgreSQL locally. Just run `docker-compose up`, and the system is live.
- **Port Isolation:** Configured to run on specific ports to avoid conflicts with local environments (`App: 8081`, `DB: 5433`).

### 🔒 2. Enhanced Security (JWT & Auth)
- **Stateful to Stateless:** Migrated to a stateless authentication mechanism using **JSON Web Tokens (JWT)**.
- **Security Refactoring:** Completely rewrote the `SecurityConfig` to handle `401 Unauthorized` errors gracefully and opened specific endpoints (Swagger, Auth) while securing business logic.
- **Custom Filters:** Implemented optimized JWT Authentication filters for request interception.

### 🛡️ 3. Robust Validation & Error Handling
- **Strict DTO Validation:** Input data is strictly validated using `Jakarta Validation` constraints (e.g., NotNull, Size, Pattern) before reaching the service layer.
- **Service Layer Improvements:** Refactored business logic to ensure data integrity (e.g., checking foreign key existence before insertion).
- **Global Exception Handling:** Centralized error management to return meaningful HTTP status codes and messages to the client.

---

## 🛠️ Tech Stack

- **Language:** Java 17
- **Framework:** Spring Boot 3.x
- **Database:** PostgreSQL 16 (Containerized)
- **Containerization:** Docker & Docker Compose
- **Security:** Spring Security, JWT (JJWT)
- **Documentation:** OpenAPI / Swagger UI
- **Build Tool:** Maven

---

## ⚙️ Installation & Setup (The "One-Click" Way)

You don't need to install a database or configure environment variables manually. Docker handles everything.

### Prerequisites
- Docker Desktop (Running)

### Steps
1. **Clone the repository:**
   ```bash
   git clone [https://github.com/efeerturk7/gallerist-backend-pro.git](https://github.com/efeerturk7/gallerist-backend-pro.git)
   cd gallerist-backend-pro
Run with Docker Compose: Open your terminal in the project root and run:

Bash
docker-compose up -d
Wait for it: Give it 15-20 seconds for the Database and Java Application to initialize.

📖 API Documentation (Swagger UI)
Once the application is running, you can access the interactive API documentation to test endpoints directly.

👉 Access Swagger UI: http://localhost:8081/swagger-ui/index.html

🔑 How to Test (Authentication Flow)
Since the system is secured with JWT, follow this flow:

Register: Go to rest-authentication-controller -> /register and create a new user.

Login: Go to /authenticate with your credentials.

Copy Token: Copy the accessToken from the response body (do not include quotes).

Authorize: Click the Authorize 🔓 button at the top right of Swagger, paste the token, and click Authorize.

Test Endpoints: Now you can access protected routes like Car Controller or Customer Controller.

💾 Database Access (Optional)
If you want to inspect the database directly using a tool like DBeaver or pgAdmin:

Host: localhost

Port: 5433 (Mapped externally)

Database: gallerist_db

Username: postgres

Password: 1 (or as defined in compose.yaml)

👨‍💻 Author
[Bahadır Efe ERTÜRK] - Backend Developer

LinkedIn Profile
https://www.linkedin.com/in/efeerturk7/

GitHub Profile
https://github.com/efeerturk7