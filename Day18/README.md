Employee Management System

📌 Project Description

The Employee Management System is a Java-based project developed as part of my software development training journey.

The project is organized into day-wise folders, with each folder containing the tasks, concepts, source code, and implementations completed during that stage of training.

The project demonstrates practical knowledge of Java programming, Object-Oriented Programming, Collections, Exception Handling, File Handling, JDBC, PostgreSQL, Logging, Git, GitHub, and software development practices.

🛠️ Technologies Used
•	Java
•	Maven
•	JDBC
•	PostgreSQL
•	SQL
•	SLF4J
•	Logback
•	Git
•	GitHub
•	IntelliJ IDEA

📂 Repository Structure

The repository is organized into day-wise folders:

Employee-Management
│
├── Day-1
├── Day-2
├── Day-3
├── ...
├── Day-17
├── Day-19
│
├── README.md
└── .gitignore

Each Day-X folder contains the work completed during that particular training day.

✨ Features

Employee Module
•	Add Employee
•	View Employee
•	Search Employee
•	Update Employee
•	Delete Employee

Department Module
•	Add Department
•	View Departments
•	Search Department
•	Update Department
•	Delete Department

Database Module
•	PostgreSQL database integration
•	JDBC connectivity
•	SQL queries
•	PreparedStatement
•	CRUD operations
•	Database connection management

Validation Module
•	Employee ID validation
•	Employee data validation
•	Department validation
•	Duplicate employee email validation

Exception Handling
•	Try-catch exception handling
•	SQL exception handling
•	Database exception handling
•	Custom exception handling
•	Meaningful error messages

Logging
•	SLF4J logging
•	Logback configuration
•	INFO logs
•	DEBUG logs
•	WARN logs
•	ERROR logs
•	Console logging
•	File-based logging

Git and GitHub
•	Git version control
•	GitHub repository management
•	Feature branches
•	Pull Requests
•	Code reviews
•	Issue tracking
•	Release tags
•	Project documentation

🏗️ Project Modules

1. Employee Module

The Employee Module manages employee-related operations, including creating, retrieving, searching, updating, and deleting employee records.

2. Department Module

The Department Module manages department information and provides operations for adding, viewing, searching, updating, and deleting departments.

3. Database Module

The Database Module handles PostgreSQL database connectivity and database operations using JDBC.

4. Validation Module

The Validation Module validates employee and department information before performing operations and helps prevent invalid or duplicate data.


🔄 Application Flow

The application follows a layered architecture:

User
↓
Main / Application
↓
Service Layer
↓
DAO Layer
↓
JDBC
↓
PostgreSQL Database

Layer Responsibilities

Main / Application Layer
Starts and controls the application.

Service Layer
Contains business logic and manages application operations.

DAO Layer
Handles database operations and SQL queries.

Database Layer
Manages the connection between the application and PostgreSQL.

Validation Layer
Validates input data before processing.

Logging Layer
Tracks application execution, important events, warnings, and errors.

⚙️ Setup Instructions

1. Clone the Repository

Clone this repository to your local system using Git.

git clone <repository-url>

2. Open the Project

Open the project in IntelliJ IDEA or another Java-compatible IDE.

3. Configure Java

Make sure Java is installed and configured correctly on your system.

4. Configure PostgreSQL

Install PostgreSQL and create the required database.

Update the database connection details according to your local PostgreSQL configuration.

5. Configure Maven

Make sure Maven is installed and available in your system PATH.

Build the project using:

mvn clean install

6. Run the Application

Open the required day-wise project and run the appropriate Main class.

🗄️ Database

The project uses PostgreSQL as the relational database.

The database manages information related to:
•	Employees
•	Departments

SQL scripts and database-related files are maintained within the relevant project folders.

📝 Logging

The project uses SLF4J as the logging API and Logback as the logging implementation.

The application uses different logging levels:

TRACE
DEBUG
INFO
WARN
ERROR

Logging is used to:
•	Track application execution
•	Monitor important business operations
•	Troubleshoot application issues
•	Record warnings
•	Capture errors and exceptions
•	Store application logs

Logs can be displayed in the console and stored in log files based on the Logback configuration.

Sensitive information such as passwords, API keys, and database credentials should never be logged.


🌿 Git and GitHub Workflow

The project follows a basic Git and GitHub workflow:

Create Feature Branch
↓
Make Code Changes
↓
Commit Changes
↓
Push Feature Branch
↓
Create Pull Request
↓
Code Review
↓
Address Review Comments
↓
Merge into Main
↓
Create Release Tag

🏷️ Release

The first stable release of the Employee Management System is tagged as:

v1.0

Release tags are used to identify stable versions of the project.

📚 Learning Outcomes

Through this project, I gained practical experience in:
•	Java Programming
•	Object-Oriented Programming
•	Collections
•	Exception Handling
•	File Handling
•	JDBC
•	PostgreSQL
•	SQL
•	Application Logging
•	SLF4J and Logback
•	Git and GitHub
•	Branching and Pull Requests
•	Code Review
•	Issue Tracking
•	Release Management
•	Project Documentation

🎯 Project Objective

The objective of this project is to build and continuously improve an Employee Management System while gaining practical experience with Java development, database integration, application logging, version control, code review, and professional software development practices.


👩‍💻 Author

Saloni Bhati

BTech Computer Science and Engineering (Artificial Intelligence)

⸻

📄 License

This project is created for educational and training purposes.