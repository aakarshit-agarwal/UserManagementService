package com.fitness.UserManagementService.controller;

import com.fitness.UserManagementService.entity.User;
import com.fitness.UserManagementService.exception.InvalidInputException;
import com.fitness.UserManagementService.model.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fitness.UserManagementService.service.UserManagementService;

import java.util.List;

@RestController
@RequestMapping("/you-fit/v1/users")
public class UserManagementServiceController {
    @Autowired
    private UserManagementService userManagementService;

    @PostMapping("/")
    public ResponseEntity<String> createUser(@RequestBody final CreateUserRequest createUserRequest) {
        if(createUserRequest.getEmail().isBlank() && createUserRequest.getPhone().isBlank()) {
            throw new InvalidInputException("Email and phone can not be blank.");
        }
        if(createUserRequest.getUsername().isBlank()) {
            throw new InvalidInputException("Username can not be blank.");
        }
        return new ResponseEntity<>(userManagementService.createUser(createUserRequest), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> listUser(
            @RequestParam(value = "includeInactive", required = false, defaultValue = "false") Boolean includeInactive) {
        return new ResponseEntity<>(userManagementService.listUser(includeInactive), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable final String userId) {
        if(userId.isBlank()) {
            throw new InvalidInputException("userId can not be blank.");
        }
        return new ResponseEntity<>(userManagementService.getUser(userId), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> removeUser(@PathVariable final String userId) {
        if(userId.isBlank()) {
            throw new InvalidInputException("userId can not be blank.");
        }
        userManagementService.removeUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
