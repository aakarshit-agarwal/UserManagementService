package com.fitness.UserManagementService.exception;

public class InvalidInputException extends RuntimeException {

    public InvalidInputException(String message) {
        super(message);
    }

    public InvalidInputException() {
        super("Error: Invalid input exception");
    }
}
