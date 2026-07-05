-- ============================================
-- DAY 14 - PostgreSQL Database Design
-- Employee Management System
-- ============================================

-- TASK 2: Create Department Table

CREATE TABLE department (
                            department_id SERIAL PRIMARY KEY,
                            department_name VARCHAR(100) NOT NULL
);

-- TASK 3: Create Employees Table

CREATE TABLE employees (
                           employee_id SERIAL PRIMARY KEY,
                           employee_name VARCHAR(100) NOT NULL,
                           email VARCHAR(100) UNIQUE,
                           salary DECIMAL(10,2) CHECK (salary > 10000),
                           department_id INT
);

-- TASK 4: Add Foreign Key

ALTER TABLE employees
    ADD CONSTRAINT fk_department
        FOREIGN KEY (department_id)
            REFERENCES department(department_id);

-- TASK 5: Insert Department Data

INSERT INTO department(department_name)
VALUES
    ('IT'),
    ('HR'),
    ('Finance'),
    ('Admin');

-- Insert Employee Data

INSERT INTO employees
(employee_name, email, salary, department_id)
VALUES
    ('Ajay', 'ajay@gmail.com', 50000, 1),
    ('Ravi', 'ravi@gmail.com', 45000, 2),
    ('Priya', 'priya@gmail.com', 60000, 1);

-- TASK 6: Basic Queries

SELECT * FROM department;

SELECT * FROM employees;

-- TASK 7: WHERE Clause

SELECT *
FROM employees
WHERE salary > 50000;

SELECT *
FROM employees
WHERE department_id = 1;

-- TASK 8: ORDER BY

SELECT *
FROM employees
ORDER BY salary DESC;

SELECT *
FROM employees
ORDER BY employee_name ASC;

-- TASK 9: Aggregate Functions

SELECT COUNT(*) AS total_employees
FROM employees;

SELECT MAX(salary) AS highest_salary
FROM employees;

SELECT MIN(salary) AS lowest_salary
FROM employees;

SELECT AVG(salary) AS average_salary
FROM employees;

-- TASK 10: INNER JOIN

SELECT
    e.employee_id,
    e.employee_name,
    d.department_name,
    e.salary
FROM employees e
         INNER JOIN department d
                    ON e.department_id = d.department_id;

-- TASK 11: GROUP BY

SELECT
    department_id,
    COUNT(*) AS employee_count
FROM employees
GROUP BY department_id;

-- TASK 12: Practice Queries

-- Highest Paid Employee

SELECT *
FROM employees
ORDER BY salary DESC
    LIMIT 1;

-- Employees earning more than 40000

SELECT *
FROM employees
WHERE salary > 40000;

-- Count employees in each department

SELECT
    department_id,
    COUNT(*) AS employee_count
FROM employees
GROUP BY department_id;

-- Display employee with department name

SELECT
    e.employee_name,
    d.department_name
FROM employees e
         INNER JOIN department d
                    ON e.department_id = d.department_id;

-- Average salary per department

SELECT
    d.department_name,
    AVG(e.salary) AS average_salary
FROM employees e
         INNER JOIN department d
                    ON e.department_id = d.department_id
GROUP BY d.department_name;

-- TASK 13: Alter Employees Table

ALTER TABLE employees
    ADD COLUMN date_of_joining DATE,
ADD COLUMN mobile_number VARCHAR(15),
ADD COLUMN designation VARCHAR(100);

-- Update Employee Details

UPDATE employees
SET
    date_of_joining = '2025-01-10',
    mobile_number = '9876543210',
    designation = 'Software Engineer'
WHERE employee_id = 1;

UPDATE employees
SET
    date_of_joining = '2024-05-20',
    mobile_number = '9876543211',
    designation = 'HR Executive'
WHERE employee_id = 2;

UPDATE employees
SET
    date_of_joining = '2023-08-15',
    mobile_number = '9876543212',
    designation = 'Senior Developer'
WHERE employee_id = 3;

-- Verify Final Data

SELECT * FROM employees;