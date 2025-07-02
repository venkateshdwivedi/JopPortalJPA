# Job Portal REST API (Spring Boot + Spring Data JPA + PostgreSQL)

This is a Spring Boot-based RESTful API for managing job postings. It follows a layered architecture using Spring Data JPA for database access and PostgreSQL as the backend. The application supports full CRUD operations and allows keyword-based search in job descriptions or profiles.

## Features

1. RESTful API built with Spring Boot  
2. Integration with PostgreSQL using Spring Data JPA  
3. Full CRUD operations on job posts  
4. Keyword search in post profile or description using custom JPQL  
5. Sample job data can be preloaded using a dedicated endpoint  
6. Tested with Postman

## Technologies Used

- Java 17 or later  
- Spring Boot  
- Spring Data JPA  
- PostgreSQL  
- Maven  
- Postman


## API Endpoints

| Method | Endpoint                    | Description                                |
|--------|-----------------------------|--------------------------------------------|
| GET    | `/jobpost`                  | Retrieve all job posts                     |
| GET    | `/jobpost/{id}`             | Retrieve a job post by ID                  |
| POST   | `/jobpost`                  | Add a new job post                         |
| PUT    | `/jobpost`                  | Update an existing job post                |
| DELETE | `/jobpost/{id}`             | Delete a job post by ID                    |
| GET    | `/load`                     | Load sample job posts into the database    |
| GET    | `/jobpost/search/{keyword}` | Search jobs by profile or description      |

## Sample JSON for POST/PUT

```json
{
  "postId": 6,
  "postProfile": "DevOps Engineer",
  "postDesc": "Experience with CI/CD pipelines and Docker",
  "reqExperience": 3,
  "postTechStack": ["Docker", "Jenkins", "Kubernetes"]
}
```

## Notes

- The `postTechStack` field is a `List<String>` stored as a single column. In production, consider mapping it properly.
- Keyword search uses a custom JPQL `@Query` in the repository.
- Data is stored in PostgreSQL and is persistent across restarts.
- No frontend is included; API tested using Postman.

## Author

**Venkatesh Dwivedi**  

