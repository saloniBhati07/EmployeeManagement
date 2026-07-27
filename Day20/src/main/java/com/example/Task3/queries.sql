-- ==========================================
-- TASK 3: SQL QUERY ASSESSMENT
-- Employee Management System
-- ==========================================


-- 1. Find Employee with Highest Salary

SELECT *
FROM employee
WHERE salary = (
    SELECT MAX(salary)
    FROM employee
);


-- 2. Find Employees Earning Above 50000

SELECT *
FROM employee
WHERE salary > 50000;


-- 3. Count Employees Department-wise

SELECT department,
       COUNT(*) AS employee_count
FROM employee
GROUP BY department;


-- 4. Display Employee with Department Details

SELECT id,
       name,
       email,
       designation,
       salary,
       department
FROM employee;


-- 5. Find Average Salary by Department

SELECT department,
       AVG(salary) AS average_salary
FROM employee
GROUP BY department;