package com.java.vishnu.DemoProject.service.rolePermission;

import com.java.vishnu.DemoProject.models.rolePermission.CreateRolePermissionRequest;
import com.java.vishnu.DemoProject.models.rolePermission.RolePermissionResponse;

public interface RolePermissionService {
    RolePermissionResponse createRolePermission(CreateRolePermissionRequest createRolePermissionRequest);

    void deleteRolePermissionById(Long id);
}


