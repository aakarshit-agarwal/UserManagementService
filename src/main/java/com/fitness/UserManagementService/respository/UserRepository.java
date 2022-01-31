package com.fitness.UserManagementService.respository;

import com.fitness.UserManagementService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User, String> {
//    @Query(value="select u from User u where u.username = :username", nativeQuery=true)
    User findByUsername(String username);
}
