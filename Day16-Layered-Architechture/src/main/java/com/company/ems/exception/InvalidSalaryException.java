package com.company.ems.exception;

public class InvalidSalaryException extends RuntimeException {
    public InvalidSalaryException(String message) {
        super(message);
    }
}
