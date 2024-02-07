package com.java.vishnu.DemoProject.repository;

import com.java.vishnu.DemoProject.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface UserDao extends JpaRepository<User, Long> {

    User findByFirstName(String name);
    List<User> findAllByFirstName(String name);

    List<User> findAllByLastName(String lastName);

    List<User> findAllByEmail(String email);

   List<User> findAllByAge(Integer age);

    User findByDob(Date dob);
}

