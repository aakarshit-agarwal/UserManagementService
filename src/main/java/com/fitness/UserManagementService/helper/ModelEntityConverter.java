package com.fitness.UserManagementService.helper;

import com.fitness.UserManagementService.entity.User;
import com.fitness.UserManagementService.model.CreateUserRequest;

public class ModelEntityConverter {
    public static User convertCreateUserRequestToUser(final CreateUserRequest createUserRequest) {
        return new User(createUserRequest.getUsername(), createUserRequest.getFirstName(),
                createUserRequest.getLastName(), createUserRequest.getEmail(), createUserRequest.getPhone());
    }
}
