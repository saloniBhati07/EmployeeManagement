package com.example.Task5;
import com.example.Task5.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService {

    private final List<Department> departments = new ArrayList<>();

    // Add Department
    public void addDepartment(Department department) {
        departments.add(department);
        System.out.println("Department added successfully.");
    }

    // View Departments
    public List<Department> getAllDepartments() {
        return departments;
    }

    // Search Department
    public Department searchDepartment(int id) {

        for (Department department : departments) {
            if (department.getId() == id) {
                return department;
            }
        }

        return null;
    }
}
