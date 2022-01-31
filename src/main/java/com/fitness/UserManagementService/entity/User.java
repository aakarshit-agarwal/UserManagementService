package com.fitness.UserManagementService.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public final class User {
    @Id
    @GeneratedValue(generator = "UserIdGenerator")
    @GenericGenerator(
            name = "UserIdGenerator",
            strategy = "com.fitness.UserManagementService.helper.UserIdGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    String userId;

    @Column(name = "username", unique = true)
    String username;
    @Column(name = "firstName")
    String firstName;
    @Column(name = "lastName")
    String lastName;
    @Column(name = "email")
    String userEmail;
    @Column(name = "phone")
    String userPhone;
    @Enumerated(EnumType.STRING)
    UserStatus userStatus;

    public User(String username, String firstName, String lastName, String userEmail, String userPhone) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userStatus = UserStatus.ACTIVE;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public String toString() {
        return "User( " + "ID: " + this.userId + ", USERNAME: " + this.username + ", FIRST_NAME: " + this.firstName +
                ", LAST_NAME: " + this.lastName + ", EMAIL: " + this.userEmail + ", PHONE: " + this.userPhone +
                ", STATUS: " + this.userStatus + " )";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return userId != null && Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
