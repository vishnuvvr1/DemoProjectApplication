package com.java.vishnu.DemoProject.controller.user;

import com.java.vishnu.DemoProject.models.user.CreateUserRequest;
import com.java.vishnu.DemoProject.models.user.UpdateUserRequest;
import com.java.vishnu.DemoProject.models.user.User;
import com.java.vishnu.DemoProject.repository.Permission.PermissionRepository;
import com.java.vishnu.DemoProject.repository.customer.CustomerDao;
import com.java.vishnu.DemoProject.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "User Controller", description = "Manages users in this demo API")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    @Operation(summary = "Create User", responses = {@ApiResponse(description = "OK",
            responseCode = "201",
            content = @Content(schema = @Schema(implementation = CreateUserRequest.class)))
    })
    public ResponseEntity<User> createUser(@RequestBody CreateUserRequest createUserRequest) {
        User user = userService.createuser(createUserRequest);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }


    @GetMapping("/users/{id}")
    @Operation(summary = "Get User By Id", responses = {@ApiResponse(description = "Ok", responseCode = "200",
            content = @Content(schema = @Schema(implementation = User.class)))
    })
    public ResponseEntity<User> getUserByid(@PathVariable(name = "id") Long userid) {
        User user = userService.getUserByid(userid);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    @Operation(summary = "Delete User By Id", responses = {@ApiResponse(description = "Ok", responseCode = "200",
            content = @Content(schema = @Schema(implementation = void.class)))
    })

    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        String user = "UserDeleted";
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/users")
    @Operation(summary = "List All Users", responses = {@ApiResponse(description = "Ok", responseCode = "200",
            content = @Content(schema = @Schema(implementation = User.class)))
    })

    public ResponseEntity<List<User>> getAllUsers(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) Date dob) {
        List<User> users = userService.getAllUsers(id, firstName, lastName, email, age, dob);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    @Operation(summary = "Update Users", responses = {@ApiResponse(description = "Ok", responseCode = "200",
            content = @Content(schema = @Schema(implementation = UpdateUserRequest.class)))
    })

    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UpdateUserRequest updateUserRequest) {
        User user = userService.updateUser(id, updateUserRequest);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @GetMapping("users/get/{name}")
    @Operation(summary = "Get User By First Name", responses = {@ApiResponse(description = "Ok", responseCode = "200",
            content = @Content(schema = @Schema(implementation = User.class)))
    })

    public ResponseEntity<User> getUserByFirstName(@PathVariable String name) {
        User user = userService.getUserByFirstName(name);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @GetMapping("/dev")
    public ResponseEntity<String> devEndpoint() {
        return ResponseEntity.ok("Vishnu Java Developer");
    }

}