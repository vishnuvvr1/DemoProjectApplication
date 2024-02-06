package com.java.vishnu.DemoProject.repository.Permission;

import com.java.vishnu.DemoProject.models.permission.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PermissionDao extends JpaRepository<Permission, Long> {
    Permission getPermissionById(Long permissionId);
}


