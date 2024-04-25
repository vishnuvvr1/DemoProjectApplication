package com.java.vishnu.DemoProject.repository.Permission;

import com.java.vishnu.DemoProject.models.permission.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissionDao extends JpaRepository<Permission, Long> {
    Permission getPermissionById(Long permissionId);

    List<Permission> findAllByName(String name);

    List<Permission> findAllByDescription(String description);

    List<Permission> findAllByType(String type);

    Permission findByName(String permissionName);
}



