package com.example.Task10;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static final Logger logger= LoggerFactory.getLogger(Main.class);
    public static void main(String[] args){
        logger.info("Application started");
        EmployeeService employeeService= new EmployeeService();

//        employeeService.testlogger();
        employeeService.addEmployee();
        employeeService.updateEmployee();
        employeeService.deleteEmployee();
        employeeService.getEmployee();

        logger.info("Application finished");

    }
}
