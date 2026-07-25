package com.example.Task5;

import java.util.List;

public class DepartmentService {

    private final DepartmentDAO departmentDAO;

    // Constructor
    public DepartmentService() {
        departmentDAO = new DepartmentDAO();
    }

    // Add Department
    public void addDepartment(Department department) {

        if (department == null) {
            System.out.println("Department cannot be null.");
            return;
        }

        if (department.getName() == null ||
                department.getName().trim().isEmpty()) {

            System.out.println("Department name cannot be empty.");
            return;
        }

        departmentDAO.addDepartment(department);
    }

    // View All Departments
    public void viewDepartments() {

        List<Department> departments =
                departmentDAO.getAllDepartments();

        if (departments.isEmpty()) {

            System.out.println("No departments found.");

        } else {

            System.out.println("All Departments:");

            for (Department department : departments) {
                System.out.println(department);
            }
        }
    }

    // Search Department
    public void searchDepartment(int id) {

        if (id <= 0) {
            System.out.println("Invalid Department ID.");
            return;
        }

        Department department =
                departmentDAO.searchDepartment(id);

        if (department != null) {

            System.out.println("Department found:");
            System.out.println(department);

        } else {

            System.out.println(
                    "Department not found with id: " + id);
        }
    }
}