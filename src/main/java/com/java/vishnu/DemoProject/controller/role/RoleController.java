package com.java.vishnu.DemoProject.controller.role;

import com.java.vishnu.DemoProject.exceptions.UserNotFoundException;
import com.java.vishnu.DemoProject.models.role.CreateRoleRequest;
import com.java.vishnu.DemoProject.models.role.Role;
import com.java.vishnu.DemoProject.models.role.UpdateRoleRequest;
import com.java.vishnu.DemoProject.service.role.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Role Controller", description = "Manage Role In Demo API")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @CrossOrigin(value = "*")
    @PostMapping("/roles")
    @Operation(summary = "Create Roles", responses = {@ApiResponse(description = "Ok",
            responseCode = "201",
            content = @Content(schema = @Schema(implementation = CreateRoleRequest.class)))})

    public ResponseEntity<Role> createRole(@RequestBody CreateRoleRequest createRoleRequest) {
        Role role = roleService.createRole(createRoleRequest);
        return new ResponseEntity<>(role, HttpStatus.CREATED);

    }

    @CrossOrigin(value = "*")
    @GetMapping("/roles/{id}")
    @Operation(summary = "Get Role By Id", responses = {@ApiResponse(description = "Ok",
            responseCode = "200",
            content = @Content(schema = @Schema(implementation = Role.class)))})

    public Role getRoleById(@PathVariable(name = "id") Long id) throws UserNotFoundException {

        Role role = roleService.getRoleById(id);
        return new ResponseEntity<>(role, HttpStatus.OK).getBody();
    }


    @CrossOrigin(value = "*")
    @DeleteMapping("/role/{id}")
    @Operation(summary = "Delete Role By Id", responses = {@ApiResponse(description = "Ok",
            responseCode = "200",
            content = @Content(schema = @Schema(implementation = void.class)))})

    public ResponseEntity<String> deleteRoleById(@PathVariable Long id) {
        roleService.deleteRoleById(id);
        String role = "delete by id";
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @CrossOrigin(value = "*")
    @GetMapping("/roles")
    @Operation(summary = "List All Roles", responses = {@ApiResponse(description = "Ok",
            responseCode = "200",
            content = @Content(schema = @Schema(implementation = void.class)))})

    public ResponseEntity<List<Role>> getAllRoles(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String displayName,
            @RequestParam(required = false) String internal) {
        List<Role> roles = roleService.getAllRoles(id, name, description, type, displayName, internal);
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @CrossOrigin(value = "*")
    @PutMapping("/roles/{id}")
    @Operation(summary = "Update roles", responses = {@ApiResponse(description = "Ok", responseCode = "200",
            content = @Content(schema = @Schema(implementation = UpdateRoleRequest.class)))
    })

    public ResponseEntity<Role> updateRoles(@PathVariable Long id, @RequestBody UpdateRoleRequest updateRoleRequest) {
        Role role = roleService.updateRoles(id, updateRoleRequest);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

}
