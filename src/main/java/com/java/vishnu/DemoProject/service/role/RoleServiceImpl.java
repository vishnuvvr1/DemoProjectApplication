package com.java.vishnu.DemoProject.service.role;

import com.java.vishnu.DemoProject.exceptions.UserNotFoundException;
import com.java.vishnu.DemoProject.models.role.CreateRoleRequest;
import com.java.vishnu.DemoProject.models.role.Role;
import com.java.vishnu.DemoProject.models.role.UpdateRoleRequest;
import com.java.vishnu.DemoProject.repository.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role createRole(CreateRoleRequest createRoleRequest) {
        Role role = new Role();
        role.setName(createRoleRequest.getName());
        role.setDescription(createRoleRequest.getDescription());
        role.setType(createRoleRequest.getType());
        role.setDisplayName(createRoleRequest.getDisplayName());
        role.setInternal(createRoleRequest.isInternal());
        return roleRepository.createRole(role);
    }

    @Override
    public Role getRoleById(Long id) throws UserNotFoundException {
        Role role= roleRepository.getRloeById(id);
        if(role == null){
            throw new UserNotFoundException("Role not found with id: " + id);
        }
        return roleRepository.getRloeById(id);
    }

    @Override
    public void deleteRoleById(Long id) {
        roleRepository.deleteById(id);

    }

    @Override
    public List<Role> getAllRoles(Long id, String name, String description, String type, String displayName, String internal) {
        return roleRepository.getAllRole(id, name, description, type, displayName, id);
    }

    @Override
    public Role updateRoles(Long id, UpdateRoleRequest updateRoleRequest) {
        Role role = roleRepository.getRloeById(id);
        role.setDescription(updateRoleRequest.getDescription());
        role.setDisplayName(updateRoleRequest.getDisplayName());
        return roleRepository.updateRole(role);
    }
}