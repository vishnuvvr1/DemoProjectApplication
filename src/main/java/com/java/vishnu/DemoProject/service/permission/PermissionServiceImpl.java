package com.java.vishnu.DemoProject.service.permission;

import com.java.vishnu.DemoProject.exceptions.UserNotFoundException;
import com.java.vishnu.DemoProject.models.permission.CreatePermissionRequest;
import com.java.vishnu.DemoProject.models.permission.Permission;
import com.java.vishnu.DemoProject.models.permission.UpdatePermissionRequest;
import com.java.vishnu.DemoProject.repository.Permission.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
@Service
public class  PermissionServiceImpl implements  PermissionService
{
    @Autowired
    private PermissionRepository permissionRepository;


    @Override
    public Permission createpermission(CreatePermissionRequest createPermissionRequest) {
        Permission permission = new Permission();
        permission.setName(createPermissionRequest.getName());
        permission.setDescription(createPermissionRequest.getDescription());
        permission.setType(createPermissionRequest.getType());
        return permissionRepository.createPermission(permission);
    }

    @Override
    public void deletePermissionById(Long id) {
        permissionRepository.deletePermissionById(id);
    }

    @Override
    public Permission getPermissionById(Long permissionId) throws UserNotFoundException{
        Permission permission = permissionRepository.getPermissionById(permissionId);
        if (permission == null){
            throw new UserNotFoundException("Id not found : " + permissionId);
        }
        return permissionRepository.getPermissionById(permissionId);
    }

    @Override
    public List<Permission> getAllPermission(Long id, String name, String description, String type) {
        return permissionRepository.getAllPermission(id,name,description,type);
    }

    @Override
    public Permission updatePermission(Long id, UpdatePermissionRequest updatePermissionRequest) {
        Permission permission = permissionRepository.getPermissionById(id);
        permission.setDescription(updatePermissionRequest.getDescription());
        permission.setType(updatePermissionRequest.getType());

        return permissionRepository.updatePermission(permission);
    }
}
