package com.example.Task6;

public class Main {
    public static void main(String[] args){
        EmployeeService employeeService= new EmployeeService();
//        employeeService.testlogger();
        employeeService.addEmployee();
        employeeService.updateEmployee();
        employeeService.deleteEmployee();
        employeeService.getEmployee();
        employeeService.checkEmployeeId(-5);
        employeeService.searchEmployee(false);
        employeeService.checkDuplicateEmail(true);



    }
}
