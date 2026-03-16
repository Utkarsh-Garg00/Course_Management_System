# Course Management System

A simple **Spring Boot web application** to manage courses.
The application allows users to **add, update, delete, view, search, and sort courses** through a clean web interface.

---

## Features

* View all courses in a dashboard
* Add a new course
* Update existing course details
* Delete a course
* View detailed course information
* Search courses using a filter
* Sort courses by ID, Name, Duration, or Instructor
* Dashboard statistics

  * Total Courses
  * Total Instructors

---

## Technologies Used

* Java
* Spring Boot
* Thymeleaf
* Bootstrap 5
* Maven
* HTML / CSS / JavaScript

---

## Project Structure

```
Course_Management_System
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── controller
│   │   │       ├── CourseController.java
│   │   │       └── CourseViewController.java
│   │   │
│   │   └── resources
│   │       ├── templates
│   │       │   ├── index.html
│   │       │   ├── course.html
│   │       │   └── details.html
│   │       │
│   │       └── application.properties
│
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

---

## Requirements

Before running the project, make sure the following software is installed:

* **Java JDK 17 or later**
* **Git**
* Internet connection (for downloading dependencies)

Maven installation is **not required** because this project uses the **Maven Wrapper**.

---

## How to Run the Project

### 1. Clone the Repository

```
git clone https://github.com/Utkarsh-Garg00/Course_Management_System.git
```

### 2. Navigate to the Project

```
cd Course_Management_System
```

### 3. Run the Application

For **Windows**

```
mvnw.cmd spring-boot:run
```

For **Mac / Linux**

```
./mvnw spring-boot:run
```

---

## Open the Application

Once the server starts, open your browser and go to:

```
http://localhost:9069/courses
```

---


## Future Improvements

Possible enhancements for the project:

* Pagination for large course lists
* Course category management
* User authentication (admin login)
* REST API integration with frontend frameworks
* Database integration with MySQL/PostgreSQL

---


