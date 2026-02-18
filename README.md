# 🚗 Gallerist - Cloud-Native Car Gallery API

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Render-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)
![Redis](https://img.shields.io/badge/Redis-Caching-DC382D?style=for-the-badge&logo=redis&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-Containerized-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![GitHub Actions](https://img.shields.io/badge/GitHub_Actions-CI%2FCD-2088FF?style=for-the-badge&logo=github-actions&logoColor=white)
![Deployment](https://img.shields.io/badge/Deploy-Render-46E3B7?style=for-the-badge&logo=render&logoColor=white)

**Gallerist** is a production-ready, cloud-native REST API designed for managing car gallery operations.

This project demonstrates a modern **DevOps-oriented architecture**. It is fully containerized with **Docker**, uses **Redis** for advanced caching strategies, stores data in **PostgreSQL**, and is automatically deployed via a **CI/CD pipeline** using GitHub Actions.

---

## 🔗 LIVE DEMO & DOCUMENTATION

The API is live on Render Cloud! You can test all endpoints via the interactive Swagger interface:

👉 **[CLICK HERE TO OPEN SWAGGER UI](https://gallerist-backend-pro.onrender.com/swagger-ui/index.html)**

---

## 🏗 System Architecture & Workflow

### 🔄 CI/CD Pipeline (Deployment Flow)
Everything is automated using GitHub Actions.

> **💻 Developer Push** 👉  **⚙️ GitHub Actions (Build & Test)** 👉  **🐳 Docker Hub (Image Registry)** 👉  **☁️ Render (Auto Deploy)**

### ⚙️ Runtime Architecture
How the application works in production:

1.  **🌍 Client Request:** User sends a request via Swagger or Postman.
2.  **🛡️ Security Layer:** JWT Filter validates the token.
3.  **☕ Spring Boot Core:** Business logic processes the request.
4.  **⚡ Redis Cache:** Checks if data exists in cache (High Speed).
5.  **🐘 PostgreSQL:** If not in cache, fetches from Database (Reliable Storage).

---

## 🚀 Key Technical Features (Feb 2026 Update)

This project has been refactored from a monolithic local app to a distributed cloud system with a heavy focus on performance.

### 1. ⚡ Advanced Caching Strategy (Redis Implementation)
The caching mechanism is not just a simple store; it implements the **Cache-Aside Pattern** and **Smart Invalidation**:

* **Custom Serialization (`RedisConfig`):**
    * Implemented a custom `RedisTemplate` using `GenericJackson2JsonRedisSerializer`.
    * Data is stored as human-readable **JSON** instead of default binary hex, making debugging and maintenance easier.
* **Service Abstraction (`RedisService`):**
    * Created a dedicated wrapper service encapsulating core Redis operations: `set` (with TTL), `get`, and `delete`.
* **Smart Caching Logic (`CarService`):**
    * **Read Operations (`findByBrand` & Pagination):** First checks Redis. If a **Cache Hit** occurs, data returns instantly. If a **Cache Miss** occurs, it fetches from PostgreSQL, saves to Redis with a specific TTL (Time-To-Live), and returns the data.
    * **Write Operations (`save`):** Implemented **Cache Eviction**. When a new car is added or updated, the `delete` method is triggered to invalidate old cache entries. This ensures data consistency and prevents serving stale data.

### 2. 🤖 Automated CI/CD (GitHub Actions)
* **Zero-Touch Deployment:** Every commit to the `main` branch triggers an automated workflow.
* The pipeline builds the JAR, creates a Docker image, pushes it to Docker Hub, and triggers a redeploy on Render.

### 3. ☁️ Cloud-Native Database (PostgreSQL)
* Migrated from local storage to a managed **PostgreSQL** instance on Render.
* Ensures high availability and data persistence in a production environment.

### 4. 🐳 Full Containerization (Docker)
* Uses a **Multi-Stage Dockerfile** to minimize image size.
* Ensures the application runs identically on a developer's machine and the cloud server.

---

## 🛠️ Tech Stack

| Category | Technology |
| :--- | :--- |
| **Language** | Java 21 (LTS) |
| **Framework** | Spring Boot 3.2.x |
| **Database** | PostgreSQL (Render Managed) |
| **Caching** | Redis (Render Key-Value) |
| **Serialization** | Jackson (JSON for Redis) |
| **DevOps** | Docker, GitHub Actions, Docker Hub |
| **Cloud** | Render (PaaS) |
| **Security** | Spring Security 6, JWT |
| **Docs** | OpenAPI / Swagger UI |

---

## ⚙️ How to Run Locally

Since the project is Dockerized, you can run the entire stack (App + DB + Redis) with a single command.

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/efeerturk7/gallerist-backend-pro.git](https://github.com/efeerturk7/gallerist-backend-pro.git)
    cd gallerist-backend-pro
    ```

2.  **Start with Docker Compose:**
    ```bash
    docker-compose up -d
    ```

3.  **Access the App:**
    * Swagger UI: `http://localhost:8081/swagger-ui/index.html`

---

### 👨‍💻 Author
**Bahadır Efe ERTÜRK** - Backend Developer

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Connect-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/efeerturk7/)
[![GitHub](https://img.shields.io/badge/GitHub-Follow-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/efeerturk7)