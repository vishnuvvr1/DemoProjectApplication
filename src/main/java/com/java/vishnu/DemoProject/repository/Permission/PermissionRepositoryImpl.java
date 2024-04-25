package com.java.vishnu.DemoProject.repository.Permission;

import com.java.vishnu.DemoProject.models.permission.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PermissionRepositoryImpl implements PermissionRepository {
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public Permission createPermission(Permission permission) {
        return permissionDao.save(permission);
    }

    @Override
    public Permission getPermissionById(Long id) {
        return permissionDao.findById(id).orElse(null);
    }

    @Override
    public void deletePermissionById(Long id) {
        permissionDao.deleteById(id);

    }

    @Override
    public List<Permission> getAllPermission(Long id, String name, String description, String type) {
        List<Permission> permissions= new ArrayList<>();
        if (id != null){
            permissions.add(permissionDao.findById(id).get());
            return permissions;
        }
  if (name != null){
      return permissionDao.findAllByName(name);
  }
  if (description != null){
      return permissionDao.findAllByDescription(description);
  }
  if (type != null){
      return permissionDao.findAllByType(type);
  }
        return permissionDao.findAll();
    }

    @Override
    public Permission updatePermission(Permission permission) {
        return permissionDao.save(permission);
    }

    @Override
    public Permission getPermissionByName(String permissionName) {
        return permissionDao.findByName(permissionName);
    }
}
