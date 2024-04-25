package com.java.vishnu.DemoProject.repository.rolePermission;

import com.java.vishnu.DemoProject.models.rolePermission.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RolePermissionRepositoryImpl implements RolePermissionRepository {
    @Autowired
    private RolePermissionDao rolePermissionDao;

    @Override
    public RolePermission createRolePermission(RolePermission rolePermission) {
        return rolePermissionDao.save(rolePermission);
    }

    @Override
    public void deleteRolePermissionById(Long rolePermissionId) {
        rolePermissionDao.deleteById(rolePermissionId);
    }
}
