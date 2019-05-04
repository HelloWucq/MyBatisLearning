package com.wucq.dao;

import java.util.List;

import com.wucq.entity.*;

/**
 * UserDao
 */
public interface UserDao {

    public void insert(User user);  

    public User findUserById(int userId);

    public User findUserByName(String username);

    public List<User> findAllUsers();

    public void inserUser(User user);

    public void deleteUserById(int userId);

    public void updateUserById(User user);
    
}