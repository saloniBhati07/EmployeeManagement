package com.company.ems.model;

public class Employee {

    private int id;
    private String name;
    private String email;
    private String department;
    private double salary;
    private String designation;

    // Default Constructor
    public Employee() {
    }

    // Parameterized Constructor (without id)
    public Employee(String name, String email, String department, double salary, String designation) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.salary = salary;
        this.designation = designation;
    }

    // Parameterized Constructor (with id)
    public Employee(int id, String name, String email, String department, double salary, String designation) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.salary = salary;
        this.designation = designation;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", designation='" + designation + '\'' +
                '}';
    }
}