package com.java.vishnu.DemoProject.repository;

import com.java.vishnu.DemoProject.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

    User findByFirstName(String name);
}
