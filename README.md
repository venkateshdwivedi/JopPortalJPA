# Job Portal API - Spring Boot Project

This is a secure and modular Job Portal backend application built using Spring Boot. It provides RESTful APIs for job post management and user registration with authentication and authorization handled through Spring Security. The application uses PostgreSQL as the database and includes AOP (Aspect-Oriented Programming) features for logging, validation, and performance monitoring.

## Features

- Load and retrieve job posts using REST APIs
- Search job posts by keyword (profile/description)
- Register new users with encrypted passwords using BCrypt
- Authenticate users using Spring Security with DAO-based authentication
- In-memory user setup supported for testing (configurable)
- Role-based access control using Spring Security
- Logs method calls and completions using AspectJ
- Validates input job post ID and converts negatives to positives before execution
- Monitors method execution time for service methods
- Clean and layered project structure following best practices

## Technologies Used

- Java 21  
- Spring Boot 3.5.3  
- Spring Web  
- Spring Data JPA  
- Spring Security  
- AspectJ (AOP)  
- PostgreSQL  
- Maven  
- Lombok  

## Database Tables

- **job_post**: Stores job-related data like profile, description, tech stack, and experience
- **users**: Stores registered user credentials used for login and authorization

## API Endpoints

### JobPost APIs (require authentication)

- **GET /jobposts**  
  Retrieve all job posts from the database.

- **GET /jobposts/{id}**  
  Retrieve a specific job post by ID. If a negative ID is passed, it is auto-converted to positive using AOP.

- **GET /jobposts/search/{keyword}**  
  Search job posts based on a keyword in job profile or description.

- **POST /load**  
  Load a predefined list of job posts into the database.

### User APIs (no authentication required)

- **POST /register**  
  Register a new user by sending a JSON payload. Passwords are encrypted using BCrypt before storage.

  **Sample JSON:**
  ```json
  {
    "id": 101,
    "username": "john_doe",
    "password": "pass123"
  }
  ```

## Spring Security Configuration

- Basic authentication is used for protected endpoints
- Credentials are fetched from PostgreSQL `users` table
- Stateless session configuration (`SessionCreationPolicy.STATELESS`)
- `BCryptPasswordEncoder` used for password encryption
- Role-based access set to `USER` via custom `UserPrincipal` class

## AOP Features

- **LoggingAspect**: Logs method entry and exit for `getjob(int id)` in `JobService`
- **ValidationAspect**: Intercepts the method and corrects any negative job post ID to positive before execution
- **PerformanceMonitorAspect**: Logs method execution time for all methods in `JobService`

## Project Structure

- `model`: Contains JPA entities (`JobPost`, `User`) and custom `UserPrincipal`
- `controller`: REST controllers for user and job-related operations
- `service`: Business logic, validation, and AOP-monitored methods
- `repo`: Repository interfaces for JPA operations
- `config`: Spring Security configuration including authentication provider and filter chain
- `aop`: Contains AOP classes for logging, validation, and performance monitoring

## How to Run

1. Ensure PostgreSQL is running
2. Create a database and configure credentials in `application.properties`
3. Run the application using:

   ```bash
   mvn spring-boot:run
   ```

4. Use Postman to test APIs (Authorization tab: Basic Auth with registered credentials)

## Postman Testing (Screenshots included)

- Registering a new user at `/register`
- Retrieving all job posts after authentication
- Accessing `/jobposts/{id}` with positive and negative IDs
- Inserting and viewing data in PostgreSQL job_post and users tables
- Console logs showing AOP logging and execution time in VS Code

## Security & Access Control

- All job post APIs are protected and require authentication
- Only registered users can access protected APIs
- User credentials are stored securely with encrypted passwords
- DAO-based authentication configured via `UserDetailsService`

##  Screenshots

### 1. Get All Job Posts (Secured Endpoint)
![Get Job Posts](https://github.com/venkateshdwivedi/JopPortalJPA/blob/main/screenshots/postman_get_jobposts.png)

### 2. Get Specific Job Post by ID (Validation + Logging)
![Get Job Post by ID](https://github.com/venkateshdwivedi/JopPortalJPA/blob/main/screenshots/postman_get_jobpost_id.png)

### 3. Add New User (User Registration Endpoint)
![Add New User](https://github.com/venkateshdwivedi/JopPortalJPA/blob/main/screenshots/postman_add_user.png)

### 4. PostgreSQL JobPost Table View
![PostgreSQL Table](https://github.com/venkateshdwivedi/JopPortalJPA/blob/main/screenshots/postgresql_table.png)

### 5. VS Code - Performance Logs & Project Structure
![VS Code Logs](https://github.com/venkateshdwivedi/JopPortalJPA/blob/main/screenshots/vscode_logs.png)


## Author

**Venkatesh Dwivedi**  
GitHub: [github.com/venkateshdwivedi](https://github.com/venkateshdwivedi)  
LinkedIn: [linkedin.com/in/venkateshdwivedi](https://linkedin.com/in/venkateshdwivedi)
