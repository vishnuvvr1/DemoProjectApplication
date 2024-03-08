package com.java.vishnu.DemoProject.service.role;

import com.java.vishnu.DemoProject.models.role.CreateRoleRequest;
import com.java.vishnu.DemoProject.models.role.Role;
import com.java.vishnu.DemoProject.models.role.UpdateRoleRequest;

import java.util.List;

public interface RoleService {
    Role createRole(CreateRoleRequest createRoleRequest);

    Role getRoleById(Long id);

    void deleteRoleById(Long id);

    List<Role> getAllRoles(Long id, String name, String description, String type, String displayName, String internal);

    Role updateRoles(Long id, UpdateRoleRequest updateRoleRequest);
}





