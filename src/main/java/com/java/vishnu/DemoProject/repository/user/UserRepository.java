package com.java.vishnu.DemoProject.repository.user;

import com.java.vishnu.DemoProject.models.user.User;

import java.util.Date;
import java.util.List;

public interface UserRepository {
    User createUser(User user);

    User getUserByid(Long id);

    void deleteUserByid(Long id);

    List<User> getAllUsers(Long id, String firstName, String lastName, String email, Integer age, Date dob);

    User updateUser(User user);

    User getUserByFirstName(String name);


    User getUserByEmail(String userEmail);

}

