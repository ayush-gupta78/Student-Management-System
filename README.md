# Student REST API

A Spring Boot REST API for managing student records.

Built with Spring Boot 4.x, JPA, PostgreSQL, Lombok, and ModelMapper.

---

## What It Does

Exposes a full CRUD API under `/api/students`:

| Method | Endpoint              | Description                        |
|--------|-----------------------|------------------------------------|
| GET    | `/api/students`       | Fetch all students                 |
| GET    | `/api/students/{id}`  | Fetch a student by ID              |
| POST   | `/api/students`       | Create a new student               |
| PUT    | `/api/students/{id}`  | Replace a student (full update)    |
| PATCH  | `/api/students/{id}`  | Partially update a student         |
| DELETE | `/api/students/{id}`  | Delete a student by ID             |

## Prerequisites

- **Java 25+**
- **Maven** (or use the included `./mvnw` wrapper)
- **PostgreSQL** running on port `9999` with a database named `studentDB`

---

## Database Setup

```sql
-- Run in psql or your preferred PostgreSQL client
CREATE DATABASE "studentDB";
```

Copy `application.properties.example` → `application.properties` and fill in your own DB host, username, and password.

Hibernate will auto-create/update the `student` table on startup (`ddl-auto=update`).

---

## Running the App

**Using the Maven wrapper (recommended):**

```bash
./mvnw spring-boot:run
```

**Or build and run the JAR:**

```bash
./mvnw package
java -jar target/restApi-0.0.1-SNAPSHOT.jar
```

The server starts on **`http://localhost:8080`**.

---

## Tech Stack

| Layer       | Technology                          |
|-------------|-------------------------------------|
| Framework   | Spring Boot 4.0.3                   |
| Language    | Java 25                             |
| Database    | PostgreSQL                          |
| ORM         | Spring Data JPA / Hibernate         |
| Mapping     | ModelMapper 3.2.4                   |
| Boilerplate | Lombok                              |
| Validation  | Jakarta Bean Validation             |
