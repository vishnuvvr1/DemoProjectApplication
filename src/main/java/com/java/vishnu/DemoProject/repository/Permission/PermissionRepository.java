package com.java.vishnu.DemoProject.repository.Permission;

import com.java.vishnu.DemoProject.models.permission.Permission;

import java.util.List;

public interface PermissionRepository {

    Permission createPermission(Permission permission);

    Permission getPermissionById(Long id);

    void deletePermissionById(Long id);

    List<Permission> getAllPermission(Long id, String name, String description, String type);

    Permission updatePermission(Permission permission);

    Permission getPermissionByName(String permissionName);
}
