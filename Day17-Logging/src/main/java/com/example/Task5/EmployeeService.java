package com.example.Task5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EmployeeService {
    private static final Logger logger= LoggerFactory.getLogger(EmployeeService.class);
    public void addEmployee(){
        logger.debug("Entering addEmployee()");
        logger.debug("Employee object received");
        logger.debug("Database operation started");

        logger.info("Employee created successfully");
    }
    public void updateEmployee(){
        logger.debug("Entering updateEmployee()");
        logger.debug("Employee object received");
        logger.debug("Database operation started");
        logger.info("Employee updated successfully");

    }
    public void deleteEmployee(){
        logger.debug("Entering deleteEmployee()");
        logger.debug("Database operation started");
        logger.info("Employee deleted successfully");
    }
    public void getEmployee()
    {logger.debug("Entering getEmployee()");
        logger.debug("Database operation started");
        logger.info("Employee retrieved successfully");
    }
}
