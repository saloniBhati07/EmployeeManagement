package com.example.Task5;

import com.example.Task5.EmployeeService;

public class Main {
    public static void main(String[] args){
        EmployeeService employeeService= new EmployeeService();
//        employeeService.testlogger();
        employeeService.addEmployee();
        employeeService.updateEmployee();
        employeeService.deleteEmployee();
        employeeService.getEmployee();
    }
}
