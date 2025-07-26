# CodeLocker - Backend API

This is the backend REST API for CodeLocker, a full-stack personal code snippet manager. It is built with Java and the Spring Boot framework, providing a secure, robust, and scalable service for the frontend application.

## Features

* **Full CRUD Functionality:** Create, Read, Update, and Delete code snippets.
* **Secure Authentication:** User registration and login system built with Spring Security.
* **User-Specific Data:** Endpoints are protected, ensuring users can only access their own snippets.
* **Persistent Storage:** Data is stored in a permanent MySQL database.
* **Professional Error Handling:** A global exception handler provides clean, structured error responses.

## Technology Stack

* **Languages:** Java 17
* **Framework:** Spring Boot
* **Security:** Spring Security (Basic Auth)
* **Database:** Spring Data JPA / Hibernate, MySQL
* **Build Tool:** Maven
* **Code Quality:** Lombok

## API Endpoints

### Authentication (`/api/auth`)

| Method | Endpoint              | Description                      | Public |
| :----- | :-------------------- | :------------------------------- | :----- |
| `POST` | `/register`           | Registers a new user.            | Yes    |
| `GET`  | `/me`                 | Checks credentials and gets user.| No     |

### Snippets (`/api/snippets`)

*All snippet endpoints require authentication.*

| Method   | Endpoint  | Description                       |
| :------- | :-------- | :-------------------------------- |
| `GET`    | `/`       | Gets all snippets for the logged-in user. |
| `POST`   | `/`       | Creates a new snippet for the user.     |
| `GET`    | `/{id}`   | Gets a single snippet by its ID.      |
| `PUT`    | `/{id}`   | Updates an existing snippet.      |
| `DELETE` | `/{id}`   | Deletes a snippet by its ID.        |

## Setup and Running Locally

1.  **Prerequisites:**
    * Java (JDK 17 or higher)
    * Maven
    * MySQL Server

2.  **Clone the repository:**
    ```bash
    git clone [https://github.com/your-username/codelocker-springboot-backend.git](https://github.com/your-username/codelocker-springboot-backend.git)
    cd codelocker-springboot-backend
    ```

3.  **Configure the database:**
    * Create a new MySQL database named `codelocker_db`.
    * Open `src/main/resources/application.properties`.
    * Update the `spring.datasource.url`, `username`, and `password` to match your local MySQL installation.

4.  **Run the application:**
    ```bash
    mvn spring-boot:run
    ```
    The application will start on `http://localhost:8080`.
