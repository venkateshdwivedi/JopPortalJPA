# Job Portal REST API (Spring Boot + Spring Data JPA + PostgreSQL + AOP)

This is a Spring Boot-based RESTful API that allows managing job postings. It demonstrates layered architecture with Spring Data JPA for database access, uses PostgreSQL as the backend database, and integrates Aspect-Oriented Programming (AOP) for logging, performance monitoring, and input validation.

## Features

1. RESTful API built using Spring Boot  
2. Spring Data JPA for ORM and database interaction  
3. PostgreSQL as a relational database  
4. Full CRUD operations for job posts  
5. Search jobs by keyword in description or profile  
6. Preload sample data using a dedicated endpoint  
7. Spring AOP:
   - Method-level logging (before/after)
   - Performance monitoring for service methods
   - Auto-correction of negative job IDs  
8. Tested thoroughly using Postman

## Technologies Used

- Java 17+  
- Spring Boot  
- Spring Data JPA  
- Spring AOP  
- PostgreSQL  
- Maven  
- Postman  

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/venkateshdwivedi/JopPortalJPA.git
cd JopPortalJPA
```

### 2. Configure PostgreSQL

Create a PostgreSQL database named `springjdbc`, and update `application.properties` with your DB credentials:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/springjdbc
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Run the Application

```bash
mvn spring-boot:run
```

## API Endpoints

| Method | Endpoint                    | Description                                      |
|--------|-----------------------------|--------------------------------------------------|
| GET    | `/jobpost`                  | Get all job posts                                |
| GET    | `/jobpost/{id}`             | Get job post by ID (auto-corrects negative ID)   |
| POST   | `/jobpost`                  | Add a new job post                               |
| PUT    | `/jobpost`                  | Update an existing job post                      |
| DELETE | `/jobpost/{id}`             | Delete job post by ID                            |
| GET    | `/jobpost/search/{keyword}` | Search by keyword in profile or description      |
| GET    | `/load`                     | Preload sample job posts into the database       |

## Sample JSON for POST/PUT

```json
{
  "postId": 101,
  "postProfile": "Java Backend Developer",
  "postDesc": "Must have experience in Spring Boot and Java",
  "reqExperience": 3,
  "postTechStack": ["Java", "Spring Boot", "REST API"]
}
```

## AOP in This Project

### LoggingAspect
- Logs method name **before** and **after** `getjob()` is called.

### PerformanceMonitorAspect
- Measures time taken for execution of **all service methods**.

### ValidationAspect
- Automatically converts negative job post IDs to positive before `getjob()` executes.

## Notes

- Project follows layered architecture:
  - Controller layer
  - Service layer
  - Repository (Spring Data JPA)
- The project is designed to be modular and testable.
- Use Postman to test endpoints. Example collections can be created for future reference.
- If `GET /jobpost` returns empty `{}`, ensure `/load` has been called at least once and DB is running.


## Author

**Venkatesh Dwivedi**  

