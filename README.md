# 🚗 Gallerist - Cloud-Native Car Gallery API with CI/CD

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green?style=for-the-badge&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Render-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![Redis](https://img.shields.io/badge/Redis-Caching-DC382D?style=for-the-badge&logo=redis&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-Containerized-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![GitHub Actions](https://img.shields.io/badge/GitHub_Actions-CI%2FCD-2088FF?style=for-the-badge&logo=github-actions&logoColor=white)
![Deployment](https://img.shields.io/badge/Deploy-Render-46E3B7?style=for-the-badge&logo=render&logoColor=white)

**Gallerist** is a robust, cloud-native Backend REST API designed to manage car gallery operations.

Built with **Spring Boot 3**, **Docker**, and **Redis**, this project demonstrates a modern, secure, and scalable software architecture. It features a fully automated **CI/CD pipeline**, high-performance caching, and is deployed to a live cloud environment.

---

## 🔗 LIVE DEMO

The API is currently live and running on the cloud! You can test all endpoints directly via the interactive Swagger UI:

👉 **[CLICK HERE TO ACCESS LIVE SWAGGER UI](https://gallerist-backend-pro.onrender.com/swagger-ui/index.html)**

---

## 🚀 DevOps & Performance Update (Feb 2026)

This project has evolved into a production-grade system with the integration of DevOps practices and performance optimizations.

### 🛠 Key Technical Improvements

* **⚡ Automated CI/CD Pipeline:**
  * Implemented **GitHub Actions** to automate the build and deployment process.
  * Every push to the `main` branch triggers a workflow that builds the application, pushes the Docker image to **Docker Hub**, and automatically deploys the new version to **Render**.

* **🚀 High-Performance Caching (Redis):**
  * Integrated **Redis** to implement caching mechanisms, significantly reducing database load and improving API response times for frequently accessed data.
  * Configured **Redis Pub/Sub** infrastructure (ready for event-driven messaging).

* **🐳 Containerization & Registry:**
  * Migrated to **Docker Hub** for centralized image management.
  * The application runs in a consistent environment from local development to production.

---

## 🏗 System Architecture & CI/CD Flow

The project follows a modern DevOps workflow:

```mermaid
graph LR
    A[💻 Developer Push] -->|GitHub| B(🚀 GitHub Actions)
    B -->|Build & Test| C{Tests Pass?}
    C -->|Yes| D[🐳 Build Docker Image]
    D -->|Push| E[📦 Docker Hub Registry]
    E -->|Pull & Deploy| F[☁️ Render Cloud]
    F -->|Connect| G[(🐘 PostgreSQL)]
    F -->|Cache| H[(⚡ Redis)]
1. Cloud-Native Storage
Database: Migrated to PostgreSQL (hosted on Render) for robust relational data management.

Caching: Uses Redis (hosted on Render) for high-speed data access.

2. Security Implementation
JWT (JSON Web Tokens): Stateless authentication mechanism.

Security Filter Chain: Custom filters intercept requests to validate tokens and enforce Role-Based Access Control (RBAC).

🛠️ Tech Stack
Language: Java 21 (LTS)

Framework: Spring Boot 3.2.x

Database: PostgreSQL (Render Cloud)

Caching/Messaging: Redis

DevOps: GitHub Actions (CI/CD), Docker Hub, Docker Compose

Cloud Provider: Render

Security: Spring Security 6, JWT (JJWT)

Object Mapping: MapStruct

Documentation: OpenAPI / Swagger UI

Build Tool: Maven

⚙️ How to Run Locally (Docker)
Since the project is fully Dockerized, you don't need to install Java, PostgreSQL, or Redis on your machine.

Clone the repository:

Bash
git clone [https://github.com/efeerturk7/gallerist-backend-pro.git](https://github.com/efeerturk7/gallerist-backend-pro.git)
cd gallerist-backend-pro
Run with Docker Compose:

Bash
docker-compose up -d
This command will pull the necessary images (App, Postgres, Redis) and start the entire stack.

Access the API:
Go to: http://localhost:8081/swagger-ui/index.html

🧪 Authentication Flow (How to Test)
The system is secured. To test protected endpoints (like adding a car), follow these steps in Swagger UI:

Register:

Go to Authentication Controller -> /rest/auth/register.

Create a new user.

Login:

Go to /rest/auth/login and enter your credentials.

Copy the accessToken from the response body (exclude the quotes).

Authorize:

Click the Authorize 🔓 button at the top right.

Paste the token: Bearer <YOUR_ACCESS_TOKEN>

Click Authorize -> Close.

Success:

Now you can execute requests in Address Controller or Car Controller.

👨‍💻 Author
Bahadır Efe ERTÜRK - Backend Developer