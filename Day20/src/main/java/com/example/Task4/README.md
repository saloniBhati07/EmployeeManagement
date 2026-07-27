TASK 4: JDBC Assessment

Objective

Demonstrate complete CRUD operations using Java Database Connectivity (JDBC) with PostgreSQL.

JDBC Operations Implemented

The Employee Management System implements the following employee operations:

1. Add Employee
2. View All Employees
3. Search Employee
4. Update Employee
5. Delete Employee

Database Table

The JDBC operations are performed on the existing employee table.

The employee table contains:

* id
* name
* email
* designation
* salary
* department

CRUD Operations

1. Add Employee

A new employee record is inserted into the PostgreSQL database using JDBC.

2. View All Employees

All employee records are retrieved from the PostgreSQL database and displayed.

3. Search Employee

An employee is searched using the employee ID.

4. Update Employee

Existing employee details are updated using the employee ID.

5. Delete Employee

An employee record is deleted using the employee ID.

JDBC Concepts Demonstrated

* JDBC database connectivity
* Connection
* PreparedStatement
* ResultSet
* executeQuery()
* executeUpdate()
* CRUD operations
* PostgreSQL database integration

PreparedStatement

PreparedStatement is used for database operations that require input parameters.

Parameterized queries are used instead of directly concatenating user input into SQL statements.

Example:

String sql = "SELECT * FROM employee WHERE id = ?";
PreparedStatement ps = connection.prepareStatement(sql);
ps.setInt(1, id);
ResultSet rs = ps.executeQuery();

Acceptance Criteria

* Add Employee operation implemented and tested.
* View All Employees operation implemented and tested.
* Search Employee operation implemented and tested.
* Update Employee operation implemented and tested.
* Delete Employee operation implemented and tested.
* JDBC used for database operations.
* PreparedStatement used for parameterized SQL queries.
* PostgreSQL database integration verified successfully.

