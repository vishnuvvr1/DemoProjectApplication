package com.java.vishnu.DemoProject.repository.user;

import com.java.vishnu.DemoProject.models.user.User;

import java.util.List;

public interface UserRepository {
    User createUser(User user);

    User getUserByid(Long id);

    void deleteUserByid(Long id);

    List<User> getAllUsers();

    User updateUser(User user);

    User getUserByFirstName(String name);
}
