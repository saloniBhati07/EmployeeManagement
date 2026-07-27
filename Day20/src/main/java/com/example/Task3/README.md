TASK 3: SQL Query Assessment

Objective

Demonstrate SQL query writing skills using the existing Employee Management System PostgreSQL database.

Employee Table Columns

The existing employee table contains the following columns:

* id
* name
* email
* designation
* salary
* department

SQL Queries Implemented

1. Find Employee with Highest Salary

Used the MAX() function and a subquery to find the employee who has the highest salary.

SELECT *
FROM employee
WHERE salary = (
SELECT MAX(salary)
FROM employee
);

2. Find Employees Earning Above ₹50,000

Used the WHERE clause to retrieve employees whose salary is greater than ₹50,000.

SELECT *
FROM employee
WHERE salary > 50000;

3. Count Employees Department-wise

Used COUNT() and GROUP BY to calculate the number of employees in each department.

SELECT department,
COUNT(*) AS employee_count
FROM employee
GROUP BY department;

4. Display Employee with Department Details

Displayed employee information along with the department stored in the department column.

SELECT id,
name,
email,
designation,
salary,
department
FROM employee;

5. Find Average Salary by Department

Used AVG() and GROUP BY to calculate the average salary for each department.

SELECT department,
AVG(salary) AS average_salary
FROM employee
GROUP BY department;

Concepts Demonstrated

* SELECT
* WHERE
* MAX()
* AVG()
* COUNT()
* GROUP BY
* Subqueries
* Aggregate Functions

Acceptance Criteria

* Query to find employee with highest salary executed successfully.
* Query to find employees earning above ₹50,000 executed successfully.
* Department-wise employee count query executed successfully.
* Employee and department details displayed successfully.
* Average salary by department query executed successfully.
* Query results verified using PostgreSQL.

Evidence

Screenshots of the query execution and results are available in the screenshots folder.

SQL Script

All SQL assessment queries are available in:

queries.sql