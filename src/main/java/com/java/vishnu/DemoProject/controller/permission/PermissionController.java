package com.java.vishnu.DemoProject.controller.permission;

import com.java.vishnu.DemoProject.exceptions.UserNotFoundException;
import com.java.vishnu.DemoProject.models.customer.CreateCustomerRequest;
import com.java.vishnu.DemoProject.models.permission.CreatePermissionRequest;
import com.java.vishnu.DemoProject.models.permission.Permission;
import com.java.vishnu.DemoProject.models.permission.UpdatePermissionRequest;
import com.java.vishnu.DemoProject.service.permission.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @PostMapping("/permissions")
    public Permission createPermission(@RequestBody CreatePermissionRequest createPermissionRequest) {
        return permissionService.createpermission(createPermissionRequest);
    }

    @GetMapping("/permissions/{id}")
    public Permission getPermissionById(@PathVariable(name = "id") Long permissionId) throws UserNotFoundException {

        return permissionService.getPermissionById(permissionId);
    }

    @DeleteMapping("/permission/{id}")
    public String deletePermissionById(@PathVariable Long id) {
        permissionService.deletePermissionById(id);
        return "delete by id";
    }

    @GetMapping("/permission")
    public ResponseEntity<List<Permission>> getAllPermission(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String type) {
        List<Permission> permissions = permissionService.getAllPermission(id, name, description, type);
        return new ResponseEntity<>(permissions, HttpStatus.OK);
    }

    @PutMapping("/permission/{id}")
    public Permission updatePermission(@PathVariable Long id, @RequestBody UpdatePermissionRequest updatePermissionRequest) {
        return permissionService.updatePermission(id, updatePermissionRequest);
    }

}
