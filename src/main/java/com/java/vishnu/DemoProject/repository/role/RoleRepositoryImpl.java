package com.java.vishnu.DemoProject.repository.role;

import com.java.vishnu.DemoProject.models.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RoleRepositoryImpl implements RoleRepository {
    @Autowired
    private RoleDao roleDao;

    @Override
    public Role createRole(Role role) {
        return roleDao.save(role);
    }

    @Override
    public Role getRloeById(Long id) {
        Optional<Role>role = roleDao.findById(id);
        return role.orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        roleDao.deleteById(id);

    }

    @Override
    public List<Role> getAllRole(Long id, String name, String description, String type, String displayName, Long id1) {
        List<Role> roles = new ArrayList<>();
        if (id !=null){
            roles.add(roleDao.findById(id).get());
            return roles;
        }
        if (name != null){
            return roleDao.findAllByName(name);
        }
        if (description != null){
            return roleDao.findAllByDescription(description);
        }
        if (type != null){
            return roleDao.findAllByType(type);
        }
        if (displayName != null){
            return roleDao.findAllByDisplayName(displayName);
        }
        return roleDao.findAll();
    }


    @Override
    public Role updateRole(Role role) {
        return roleDao.save(role);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleDao.findByName(roleName);
    }
}
