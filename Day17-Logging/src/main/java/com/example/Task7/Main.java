package com.example.Task7;

import com.example.Task7.EmployeeService;

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

        employeeService.databaseConnection();
        employeeService.sqlOperation();
        employeeService.findEmployee(999);



    }
}
