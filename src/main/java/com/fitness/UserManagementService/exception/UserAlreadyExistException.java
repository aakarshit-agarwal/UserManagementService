package com.fitness.UserManagementService.exception;

public class UserAlreadyExistException extends RuntimeException {

    public UserAlreadyExistException(String message) {
        super(message);
    }

    public UserAlreadyExistException() {
        super("Error: User already exist");
    }
}
