package com.example.Task9;

public class Employee {

    private int id;
    private String name;
    private String email;
    private String designation;
    private double salary;
    private String department;

    // Default Constructor
    public Employee() {
    }

    // Parameterized Constructor
    public Employee(int id, String name, String email,
                    String designation, double salary,
                    String department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.designation = designation;
        this.salary = salary;
        this.department = department;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}