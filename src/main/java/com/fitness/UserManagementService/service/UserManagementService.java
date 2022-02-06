package com.fitness.UserManagementService.service;

import com.fitness.UserManagementService.dao.UserDaoService;
import com.fitness.UserManagementService.entity.User;
import com.fitness.UserManagementService.entity.UserStatus;
import com.fitness.UserManagementService.exception.UserDoesNotExistException;
import com.fitness.UserManagementService.helper.ModelEntityConverter;
import com.fitness.UserManagementService.model.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManagementService {
    @Autowired
    private UserDaoService userDaoService;

    public String createUser(final CreateUserRequest createUserRequest) {
        final User newUser = ModelEntityConverter.convertCreateUserRequestToUser(createUserRequest);
        return userDaoService.saveUser(newUser).getUserId();
    }

    public User getUser(final String userId) {
        return userDaoService.getUser(userId);
    }

    public List<User> listUser(Boolean includeInactive) {
        List<User> userList = userDaoService.listUser();
        if(!includeInactive) {
            return userList.stream().filter(it -> it.getUserStatus() == UserStatus.ACTIVE).toList();
        }
        return userList;
    }

    public void removeUser(final String userId) {
        final User user = userDaoService.getUser(userId);
        if(user.getUserStatus() == UserStatus.INACTIVE) {
            throw new UserDoesNotExistException();
        }
        if (user.getUserStatus() == UserStatus.ACTIVE) {
            user.setUserStatus(UserStatus.INACTIVE);
            userDaoService.saveUser(user);
        }
    }
}
