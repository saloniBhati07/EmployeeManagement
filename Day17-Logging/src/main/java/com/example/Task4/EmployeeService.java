package com.example.Task4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EmployeeService {
    private static final Logger logger= LoggerFactory.getLogger(EmployeeService.class);
    public void testlogger(){
        logger.info("Employee Service started successfully.");
    }
    public void addEmployee(){
        logger.info("Employee created successfully");
    }
    public void updateEmployee(){
        logger.info("Employee updated successfully");

    }
    public void deleteEmployee(){
        logger.info("Employee deleted successfully");
    }
    public void getEmployee(){
        logger.info("Employee retrieved successfully");
    }
}
