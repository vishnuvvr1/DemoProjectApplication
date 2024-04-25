package com.java.vishnu.DemoProject.models.rolePermission;

import com.java.vishnu.DemoProject.models.permission.Permission;
import com.java.vishnu.DemoProject.models.role.Role;
import jakarta.persistence.*;

@Entity
@Table
public class RolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "role_id")
    private Role role;


    @ManyToOne(optional = false)
    @JoinColumn(name = "Permission_id")
    private Permission permission;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
