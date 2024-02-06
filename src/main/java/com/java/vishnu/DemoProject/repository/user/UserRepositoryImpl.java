package com.java.vishnu.DemoProject.repository.user;

import com.java.vishnu.DemoProject.models.user.User;
import com.java.vishnu.DemoProject.repository.UserDao;
import com.java.vishnu.DemoProject.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public List<User> getAllUsers() {
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