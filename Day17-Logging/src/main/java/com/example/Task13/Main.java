package com.example.Task13;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args){
     logger.info("Application started successfully");
     EmployeeService employeeService= new EmployeeService();
        employeeService.addEmployee();
        employeeService.updateEmployee();
        employeeService.deleteEmployee();
        employeeService.searchEmployee();
logger.info("Application shutting down");


    }
}
