package com.wucq.dao;

import java.io.IOException;
import java.util.List;

import com.wucq.entity.*;

/**
 * UserDao
 */
public interface UserDao  {

    public User findUserById(int userId) throws IOException;

    public User findUserByName(String username) throws IOException; 

    public List<User> findAllUsers() throws Exception;

    public void inserUser(User user) throws IOException;

    public void deleteUserById(int userId) throws IOException;

    public void updateUser(User user) throws Exception;
    
}