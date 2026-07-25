package com.example.Task4;

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
