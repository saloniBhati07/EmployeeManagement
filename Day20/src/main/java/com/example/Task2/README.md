TASK 2: PostgreSQL Assessment

Objective

Demonstrate PostgreSQL database operations for the Employee Management System.

Activities Completed

* Created and used the Employee Management database.
* Created the department table.
* Created the employee table.
* Added a primary key to both tables.
* Added a foreign key relationship between Employee and Department.
* Inserted department records.
* Inserted employee records.
* Updated an employee record.
* Deleted an employee record.
* Verified the results using SELECT queries.

Database Tables

Department

Column	Data Type	Constraint
department_id	INT	Primary Key
department_name	VARCHAR(100)	NOT NULL

Employee

Column	Data Type	Constraint
employee_id	INT	Primary Key
employee_name	VARCHAR(100)	NOT NULL
email	VARCHAR(150)	UNIQUE, NOT NULL
salary	NUMERIC(10,2)	NOT NULL
department_id	INT	Foreign Key

SQL Operations Performed

Create

Created the department and employee tables.

Insert

Inserted department and employee records into the database.

Update

Updated the salary of an employee using the employee ID.

Delete

Deleted an employee record using the employee ID.

Verify

Used SELECT queries to verify the results of each operation.

Acceptance Criteria

* Database operations executed successfully.
* Tables created successfully.
* Records inserted successfully.
* Records updated successfully.
* Records deleted successfully.
* Primary key and foreign key relationships implemented.

Evidence

Screenshots demonstrating table creation, record insertion, update, and deletion are available in the screenshots folder.

SQL Script

The complete SQL script is available in:

database.sql