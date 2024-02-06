package com.java.vishnu.DemoProject.controller.user;

import com.java.vishnu.DemoProject.models.user.CreateUserRequest;
import com.java.vishnu.DemoProject.models.user.UpdateUserRequest;
import com.java.vishnu.DemoProject.models.user.User;
import com.java.vishnu.DemoProject.repository.Permission.PermissionRepository;
import com.java.vishnu.DemoProject.repository.customer.CustomerDao;
import com.java.vishnu.DemoProject.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody CreateUserRequest createUserRequest) {
        User user = userService.createuser(createUserRequest);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserByid(@PathVariable(name = "id") Long userid) {
        User user = userService.getUserByid(userid);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        String user = "UserDeleted";
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UpdateUserRequest updateUserRequest) {
        User user = userService.updateUser(id, updateUserRequest);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @GetMapping("users/get/{name}")
    public ResponseEntity<User> getUserByFirstName(@PathVariable String name) {
        User user = userService.getUserByFirstName(name);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }
}