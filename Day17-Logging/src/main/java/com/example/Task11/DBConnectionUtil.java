package com.example.Task11;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBConnectionUtil{
    private static final Logger logger=
            LoggerFactory.getLogger(DBConnectionUtil.class);
    public void connect(){
        logger.debug("Attempting to connect to database.");
        try {
            logger.info("Database connection established successfully.");
        } catch (Exception e){
            logger.error("Database connection failed.", e);
        }
    }
}