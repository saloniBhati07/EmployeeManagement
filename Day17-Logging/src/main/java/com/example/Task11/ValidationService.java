package com.example.Task11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidationService {

    private static final Logger logger =
            LoggerFactory.getLogger(ValidationService.class);

    public boolean validateEmployeeId(int id) {

        logger.debug("Validating employee ID.");

        if (id <= 0) {

            logger.warn("Invalid employee ID: {}", id);

            return false;
        }

        logger.info("Employee ID validation successful.");

        return true;
    }
}