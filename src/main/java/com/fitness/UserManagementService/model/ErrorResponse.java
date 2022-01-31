package com.fitness.UserManagementService.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ErrorResponse {
    String message;
    HttpStatus status;

    public ErrorResponse(final String message, final HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
