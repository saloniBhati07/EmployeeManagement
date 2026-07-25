package com.example.Task7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;


public class EmployeeService {
    private static final Logger logger= LoggerFactory.getLogger(com.example.Task6.EmployeeService.class);
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
    //task-6 -WARN
    public void checkEmployeeId(int id){
        if(id<=0){
            logger.warn("Invalid employee ID:{}",id);
        }
    }
    public void searchEmployee(boolean found){
        if(!found){
            logger.warn("Employee search returned no reults.");
        }
    }
    public void checkDuplicateEmail(boolean duplicate){
        if(duplicate){
            logger.warn("Employee email already exixts");
        }
    }
    //task-7-ERROR
    public void databaseConnection(){
        try{
            throw new SQLException("unable to connect to database");

        }
        catch (SQLException e){
            logger.error("Database connection failed",e);
        }
    }
    public void sqlOperation(){
        try{
            throw new SQLException("SQL operation failed");

        }
        catch(SQLException e){
            logger.error("SQL exception occured", e);

        }
    }
    public void findEmployee(int id){
        try{
            if(id==999){
                throw new Exception("Employee not found");
            }
            logger.info("Employee found succesfully.");
        }
        catch(Exception e){
      logger.error("Employee not found with id:{}", id,e);
        }
    }
}


