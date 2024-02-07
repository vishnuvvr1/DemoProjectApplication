package com.java.vishnu.DemoProject.repository.user;

import com.java.vishnu.DemoProject.models.user.User;
import com.java.vishnu.DemoProject.repository.UserDao;
import com.java.vishnu.DemoProject.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserDao userDao;

    @Override
    public User createUser(User user) {
        return userDao.save(user);
    }

    @Override
    public User getUserByid(Long id) {
        return userDao.findById(id).get();
    }

    @Override
    public void deleteUserByid(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public List<User> getAllUsers(Long id, String firstName, String lastName, String email, Integer age, Date dob) {
        List<User> users = new ArrayList<>();
        if (id != null) {
            users.add(userDao.findById(id).get());

            return users;
        }
        if (firstName != null) {
            return userDao.findAllByFirstName(firstName);
        }
        if (lastName != null) {
            return userDao.findAllByLastName(lastName);
        }
        if (email != null) {
            return userDao.findAllByEmail(email);

        }
        if (age != null) {
            return userDao.findAllByAge(age);
        }
        if (dob != null) {
            users.add(userDao.findByDob(dob));
            return users;
        }
        return userDao.findAll();
    }

    @Override
    public User updateUser(User user) {
        return userDao.save(user);
    }

    @Override
    public User getUserByFirstName(String name) {

        return userDao.findByFirstName(name);
    }


}