package com.java.vishnu.DemoProject.repository.role;

import com.java.vishnu.DemoProject.models.role.Role;

import java.util.List;

public interface RoleRepository {
    Role createRole(Role role);

    Role getRloeById(Long id);

    void deleteById(Long id);

    List<Role> getAllRole(Long id, String name, String description, String type, String displayName, Long id1);


    Role updateRole(Role role);

    Role getRoleByName(String roleName);

}





