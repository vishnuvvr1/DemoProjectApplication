package com.java.vishnu.DemoProject.service.user;

import com.java.vishnu.DemoProject.models.user.CreateUserRequest;
import com.java.vishnu.DemoProject.models.user.UpdateUserRequest;
import com.java.vishnu.DemoProject.models.user.User;

import java.util.List;

public interface UserService {
    User createuser(CreateUserRequest createUserRequest);

    User getUserByid(Long id);

    void deleteUserById(Long id);

    List<User> getAllUsers();

    User updateUser(Long id, UpdateUserRequest updateUserRequest);

    User getUserByFirstName(String name);
}
