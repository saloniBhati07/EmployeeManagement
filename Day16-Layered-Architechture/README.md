# Employee Management System

## Project Overview

This project is a Java-based Employee Management System developed using Layered Architecture. It performs CRUD (Create, Read, Update, Delete) operations on employee records using JDBC and PostgreSQL.

---

## Layered Architecture

```
Presentation Layer (App.java)
        │
        ▼
Service Layer (EmployeeService.java)
        │
        ▼
DAO Layer (EmployeeDAO & EmployeeDAOImpl)
        │
        ▼
Database Layer (PostgreSQL)
```

---

## Package Structure

```
com.company.ems
│
├── dao
│   ├── EmployeeDAO.java
│   └── EmployeeDAOImpl.java
│
├── model
│   └── Employee.java
│
├── service
│   └── EmployeeService.java
│
├── util
│   ├── DBConnectionUtil.java
│   └── ValidationUtil.java
│
├── exception
│   ├── EmployeeNotFoundException.java
│   ├── InvalidDepartmentException.java
│   └── InvalidSalaryException.java
│
└── main
    └── App.java
```

---

## Technologies Used

- Java 17
- JDBC
- PostgreSQL
- Maven
- IntelliJ IDEA

---

## Database Design

### Employee Table

| Column | Data Type |
|---------|-----------|
| id | SERIAL PRIMARY KEY |
| name | VARCHAR(100) |
| email | VARCHAR(100) |
| department | VARCHAR(100) |
| salary | DOUBLE PRECISION |
| designation | VARCHAR(100) |

---

## Entity Relationship

```
Employee
---------
id
name
email
department
salary
designation
```

---

## Application Flow

1. User starts the application.
2. App calls EmployeeService.
3. EmployeeService validates employee data.
4. EmployeeDAO performs database operations.
5. DBConnectionUtil creates the database connection.
6. PostgreSQL stores or retrieves the data.

---

## Features

- Add Employee
- Get Employee by ID
- Get All Employees
- Update Employee
- Delete Employee
- Input Validation
- Custom Exceptions
- Logging
- Layered Architecture

---

## Validation Rules

- Name cannot be empty.
- Email must be valid.
- Department cannot be empty.
- Salary must be greater than 10000.

---

## Custom Exceptions

- EmployeeNotFoundException
- InvalidSalaryException
- InvalidDepartmentException

---

## Author

Saloni Bhati