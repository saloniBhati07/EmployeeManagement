package com.example.Task9;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String message){
        super(message);
    }
}
