package com.example.Task5;

import com.example.Task5.Department;
import com.example.Task5.DepartmentService;
//department
public class Main {

    public static void main(String[] args) {

        DepartmentService departmentService =
                new DepartmentService();

        // Add Department
        departmentService.addDepartment(
                new Department(1, "IT")
        );

        departmentService.addDepartment(
                new Department(2, "HR")
        );

        departmentService.addDepartment(
                new Department(3, "Finance")
        );

        // View Departments
        System.out.println("All Departments:");

        for (Department department :
                departmentService.getAllDepartments()) {

            System.out.println(department);
        }

        // Search Department
        Department department =
                departmentService.searchDepartment(2);

        System.out.println("Search Result:");

        if (department != null) {
            System.out.println(department);
        } else {
            System.out.println("Department not found.");
        }
    }
}