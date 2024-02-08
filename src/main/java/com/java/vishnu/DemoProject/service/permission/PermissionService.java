package com.java.vishnu.DemoProject.service.permission;

import com.java.vishnu.DemoProject.exceptions.UserNotFoundException;
import com.java.vishnu.DemoProject.models.permission.CreatePermissionRequest;
import com.java.vishnu.DemoProject.models.permission.Permission;
import com.java.vishnu.DemoProject.models.permission.UpdatePermissionRequest;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

public interface PermissionService {
    Permission createpermission(CreatePermissionRequest createPermissionRequest);

    void deletePermissionById(Long id);

    Permission getPermissionById(Long permissionId) throws UserNotFoundException;

    List<Permission> getAllPermission(Long id, String name, String description, String type);

    Permission updatePermission(Long id, UpdatePermissionRequest updatePermissionRequest);

}


