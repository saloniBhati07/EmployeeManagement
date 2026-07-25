package com.example.Task11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DepartmentService {

    private static final Logger logger =
            LoggerFactory.getLogger(DepartmentService.class);

    public void addDepartment() {

        logger.debug("Entering addDepartment()");

        logger.info("Department created successfully.");
    }

    public void getDepartment() {

        logger.debug("Entering getDepartment()");

        logger.info("Department retrieved successfully.");
    }

    public void updateDepartment() {

        logger.debug("Entering updateDepartment()");

        logger.info("Department updated successfully.");
    }

    public void deleteDepartment() {

        logger.debug("Entering deleteDepartment()");

        logger.info("Department deleted successfully.");
    }
}