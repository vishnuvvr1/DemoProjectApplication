package com.java.vishnu.DemoProject.controller.rolePermission;

import com.java.vishnu.DemoProject.models.rolePermission.CreateRolePermissionRequest;
import com.java.vishnu.DemoProject.models.rolePermission.RolePermissionResponse;
import com.java.vishnu.DemoProject.service.rolePermission.RolePermissionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Tag(name = "Role Permissions Controller", description = "Manage Role Permissions In Demo API")
public class RolePermissionController {
    @Autowired
    private RolePermissionService rolePermissionService;

    @CrossOrigin(value = "*")
    @PostMapping("/rolePermissions")
    @Operation(summary = "Create Role Permissions", responses = {@ApiResponse(description = "Ok",
            responseCode = "201",
            content = @Content(schema = @Schema(implementation = CreateRolePermissionRequest.class)))})

    public RolePermissionResponse createRolePermission (@RequestBody CreateRolePermissionRequest createRolePermissionRequest){
        return rolePermissionService.createRolePermission(createRolePermissionRequest);

    }

    @CrossOrigin(value = "*")
    @DeleteMapping("/role Permissions/{id}")
    @Operation(summary = "Delete RolePermissions By Id", responses = {@ApiResponse(description = "Ok",
            responseCode = "200",
            content = @Content(schema = @Schema(implementation = void.class)))})

    public ResponseEntity<String> deleteRolePermissionById(@PathVariable Long rolePermissionId) {
        rolePermissionService.deleteRolePermissionById(rolePermissionId);
        String role = "delete by id";
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

}
