package com.example.Task13;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeService {
    private static final Logger logger= LoggerFactory.getLogger(EmployeeService.class);
    public void addEmployee(){
        logger.info("Employee created successfully");
    }
    public void updateEmployee(){
        logger.info("Employee updated successfully");

    }
    public void deleteEmployee(){
        logger.info("Employee deleted successfully");
    }
    public void searchEmployee() {
        logger.info("Employee retrieved successfully");
        logger.info("Employee search completed");

    }

}
