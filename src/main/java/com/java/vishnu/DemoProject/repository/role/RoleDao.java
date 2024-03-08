package com.java.vishnu.DemoProject.repository.role;

import com.java.vishnu.DemoProject.models.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleDao extends JpaRepository<Role, Long> {
    List<Role> findAllByName(String name);

    List<Role> findAllByDescription(String description);

    List<Role> findAllByType(String type);

    List<Role> findAllByDisplayName(String displayName);
}




