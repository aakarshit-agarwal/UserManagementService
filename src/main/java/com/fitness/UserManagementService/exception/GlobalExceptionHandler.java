package com.fitness.UserManagementService.exception;

import com.fitness.UserManagementService.model.ErrorResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = UserAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> userAlreadyExistException(UserAlreadyExistException userAlreadyExistException){
        final HttpStatus errorCode = HttpStatus.CONFLICT;
        return new ResponseEntity<>(new ErrorResponse(userAlreadyExistException.getMessage(), errorCode), errorCode);
    }

    @ExceptionHandler(value = UserDoesNotExistException.class)
    public ResponseEntity<ErrorResponse> userDoesNotExistException(UserDoesNotExistException userDoesNotExistException){
        final HttpStatus errorCode = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(new ErrorResponse(userDoesNotExistException.getMessage(), errorCode), errorCode);
    }

    @ExceptionHandler(value = InvalidInputException.class)
    public ResponseEntity<ErrorResponse> invalidInputException(InvalidInputException exception){
        final HttpStatus errorCode = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(new ErrorResponse(exception.getMessage(), errorCode), errorCode);
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> dataIntegrityViolationException(DataIntegrityViolationException exception){
        final HttpStatus errorCode = HttpStatus.CONFLICT;
        return new ResponseEntity<>(new ErrorResponse("Database integrity is violated", errorCode), errorCode);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> exception(Exception exception){
        final HttpStatus errorCode = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(new ErrorResponse("Something went wrong!", errorCode), errorCode);
    }
}
