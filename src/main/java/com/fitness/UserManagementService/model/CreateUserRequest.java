package com.fitness.UserManagementService.model;

import lombok.Data;

@Data
public class CreateUserRequest {
    String username;
    String firstName;
    String lastName;
    String email;
    String phone;
}
