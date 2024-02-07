package com.java.vishnu.DemoProject.service.user;

import com.java.vishnu.DemoProject.models.user.CreateUserRequest;
import com.java.vishnu.DemoProject.models.user.UpdateUserRequest;
import com.java.vishnu.DemoProject.models.user.User;

import java.util.Date;
import java.util.List;

public interface UserService {
    User createuser(CreateUserRequest createUserRequest);

    User getUserByid(Long id);

    void deleteUserById(Long id);

    List<User> getAllUsers(Long id, String firstName, String lastName, String email, Integer age, Date dob);

    User updateUser(Long id, UpdateUserRequest updateUserRequest);

    User getUserByFirstName(String name);


}
