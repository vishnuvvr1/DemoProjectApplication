package com.java.vishnu.DemoProject.service.user;

import com.java.vishnu.DemoProject.models.user.CreateUserRequest;
import com.java.vishnu.DemoProject.models.user.UpdateUserRequest;
import com.java.vishnu.DemoProject.models.user.User;
import com.java.vishnu.DemoProject.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createuser(CreateUserRequest createUserRequest) {
        User user = new User();
        user.setFirstName(createUserRequest.getFirstName());
        user.setLastName(createUserRequest.getLastName());
        user.setEmail(createUserRequest.getEmail());
        user.setAge(createUserRequest.getAge());
        user.setDob(createUserRequest.getDob());
        return userRepository.createUser(user);

    }

    @Override
    public User getUserByid(Long id) {
        return userRepository.getUserByid(id);

    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteUserByid(id);
    }

    @Override
    public List<User> getAllUsers(Long id, String firstName, String lastName, String email, Integer age, Date dob) {
        return userRepository.getAllUsers(id, firstName, lastName, email, age, dob);
    }

    @Override
    public User updateUser(Long id, UpdateUserRequest updateUserRequest) {
        User user = userRepository.getUserByid(id);
        if (updateUserRequest.getFirstName() != null) {
            user.setFirstName(updateUserRequest.getFirstName());
        }
        if (updateUserRequest.getLastName() != null) {
            user.setLastName(updateUserRequest.getLastName());
        }
        return userRepository.updateUser(user);
    }

    @Override
    public User getUserByFirstName(String name) {
        return userRepository.getUserByFirstName(name);
    }
}
