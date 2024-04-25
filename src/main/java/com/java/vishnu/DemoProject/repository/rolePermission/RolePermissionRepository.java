package com.java.vishnu.DemoProject.repository.rolePermission;

import com.java.vishnu.DemoProject.models.rolePermission.RolePermission;

public interface RolePermissionRepository {
    RolePermission createRolePermission(RolePermission rolePermission);

    void deleteRolePermissionById(Long rolePermissionId);
}


