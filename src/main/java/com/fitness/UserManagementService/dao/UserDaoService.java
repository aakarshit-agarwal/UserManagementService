package com.fitness.UserManagementService.dao;

import com.fitness.UserManagementService.entity.User;
import com.fitness.UserManagementService.exception.UserDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fitness.UserManagementService.respository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserDaoService {
    @Autowired
    private UserRepository userRepository;

    public void saveUser(final User user) {
        userRepository.save(user);
    }

    public User getUser(final String userId) {
        final Optional<User> user = userRepository.findById(userId);
        return user.orElseThrow(UserDoesNotExistException::new);
    }

    public User getUserByUsername(final String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> listUser() {
        return userRepository.findAll();
    }

    public void updateUser(final User user) {
        userRepository.save(user);
    }

    public void deleteUser(final String userId) {
        User user = this.getUser(userId);
        userRepository.delete(user);
    }
}
