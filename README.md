# 🚗 Gallerist - Cloud-Native Car Gallery API

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Render-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)
![Redis](https://img.shields.io/badge/Redis-Caching-DC382D?style=for-the-badge&logo=redis&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-Containerized-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![GitHub Actions](https://img.shields.io/badge/GitHub_Actions-CI%2FCD-2088FF?style=for-the-badge&logo=github-actions&logoColor=white)
![Deployment](https://img.shields.io/badge/Deploy-Render-46E3B7?style=for-the-badge&logo=render&logoColor=white)

**Gallerist** is a production-ready, cloud-native REST API designed for managing car gallery operations.

This project demonstrates a modern **DevOps-oriented architecture**. It is fully containerized with **Docker**, uses **Redis** for high-performance caching, stores data in **PostgreSQL**, and is automatically deployed via a **CI/CD pipeline** using GitHub Actions.

---

## 🔗 LIVE DEMO & DOCUMENTATION

The API is live on Render Cloud! You can test all endpoints via the interactive Swagger interface:

👉 **[CLICK HERE TO OPEN SWAGGER UI](https://gallerist-backend-pro.onrender.com/swagger-ui/index.html)**

---

## 🏗 System Architecture

The diagram below illustrates the continuous deployment flow and the runtime architecture.

```mermaid
graph TD
    User([User / Client]) -->|HTTP Request| Render[Render Cloud Platform]
    
    subgraph Services
        Render -->|Forward| App[Spring Boot Application]
        App -->|Read/Write| DB[(PostgreSQL Database)]
        App -->|Cache| Redis[(Redis Cache)]
    end
    
    GitHub[GitHub Repo] -->|Push Code| Actions[GitHub Actions CI/CD]
    Actions -->|Build & Push Image| DockerHub[Docker Hub Registry]
    DockerHub -->|Pull Image| Render
🚀 Key Technical Features (Feb 2026 Update)This project has been refactored from a monolithic local app to a distributed cloud system.1. ⚡ Performance & Caching (Redis)Implemented Redis to cache frequently accessed data.Reduced database load and improved API response times significantly.Configured Redis Pub/Sub infrastructure for future event-driven features.2. 🤖 Automated CI/CD (GitHub Actions)Zero-Touch Deployment: Every commit to the main branch triggers an automated workflow.The pipeline builds the JAR, creates a Docker image, pushes it to Docker Hub, and triggers a redeploy on Render.3. ☁️ Cloud-Native Database (PostgreSQL)Migrated from local storage to a managed PostgreSQL instance on Render.Ensures high availability and data persistence in a production environment.4. 🐳 Full Containerization (Docker)Uses a Multi-Stage Dockerfile to minimize image size.Ensures the application runs identically on a developer's machine and the cloud server.🛠️ Tech StackCategoryTechnologyLanguageJava 21 (LTS)FrameworkSpring Boot 3.2.xDatabasePostgreSQL (Render Managed)CachingRedis (Render Key-Value)DevOpsDocker, GitHub Actions, Docker HubCloudRender (PaaS)SecuritySpring Security 6, JWTDocsOpenAPI / Swagger UI⚙️ How to Run LocallySince the project is Dockerized, you can run the entire stack (App + DB + Redis) with a single command.Clone the repository:Bashgit clone [https://github.com/efeerturk7/gallerist-backend-pro.git](https://github.com/efeerturk7/gallerist-backend-pro.git)
cd gallerist-backend-pro
Start with Docker Compose:Bashdocker-compose up -d
Access the App:Swagger UI: http://localhost:8081/swagger-ui/index.html👨‍💻 AuthorBahadır Efe ERTÜRK - Backend Developer