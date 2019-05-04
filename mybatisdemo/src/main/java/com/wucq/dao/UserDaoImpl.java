package com.wucq.dao;

import java.io.IOException;
import java.util.List;

import com.wucq.entity.User;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * UserDaoImpl
 */
public class UserDaoImpl implements UserDao {

    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User findUserById(int userId) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userMapper = sqlSession.getMapper(UserDao.class);
        User user = userMapper.findUserById(userId);
        return user;
    }

    @Override
    public User findUserByName(String username) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userMapper = sqlSession.getMapper(UserDao.class);
        User user = userMapper.findUserByName(username);
        return user;
    }

    @Override
    public void inserUser(User user) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userMapper = sqlSession.getMapper(UserDao.class);
        userMapper.inserUser(user);

    }

    @Override
    public void deleteUserById(int userId) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userMapper = sqlSession.getMapper(UserDao.class);

        userMapper.deleteUserById(userId);
    }

    @Override
    public void updateUser(User user) throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userMapper = sqlSession.getMapper(UserDao.class);

        userMapper.updateUser(user);
    }

    @Override
    public List<User> findAllUsers() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userMapper = sqlSession.getMapper(UserDao.class);

        List<User>result=userMapper.findAllUsers();
        return result;
    }

    @Override
    public int saveUserBatch(List<User> list) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userMapper = sqlSession.getMapper(UserDao.class);
        int result=userMapper.saveUserBatch(list);
        return result;
    }

    @Override
    public int delUserBatch(List<Integer> list) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userMapper = sqlSession.getMapper(UserDao.class);
        int result=userMapper.delUserBatch(list);
        return result;
    }
}