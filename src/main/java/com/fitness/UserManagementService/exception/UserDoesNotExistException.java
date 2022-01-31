package com.fitness.UserManagementService.exception;

public class UserDoesNotExistException extends RuntimeException {

    public UserDoesNotExistException(String message) {
        super(message);
    }

    public UserDoesNotExistException() {
        super("Error: User does not exist");
    }
}
