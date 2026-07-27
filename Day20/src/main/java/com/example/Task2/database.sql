-- TASK 2: PostgreSQL Assessment

-- View existing records
SELECT * FROM department;
SELECT * FROM employee;

-- Insert Record
INSERT INTO employee
(employee_id, employee_name, email, salary, department_id)
VALUES
    (105, 'Test Employee', 'test@example.com', 55000, 1);

-- Verify Insert
SELECT * FROM employee
WHERE employee_id = 105;

-- Update Record
UPDATE employee
SET salary = 60000
WHERE employee_id = 105;

-- Verify Update
SELECT * FROM employee
WHERE employee_id = 105;

-- Delete Record
DELETE FROM employee
WHERE employee_id = 105;

-- Verify Delete
SELECT * FROM employee
WHERE employee_id = 105;