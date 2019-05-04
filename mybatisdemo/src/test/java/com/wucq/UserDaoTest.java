package com.wucq;

import java.io.IOException;

import com.wucq.dao.UserDao;
import com.wucq.entity.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.BasicConfigurator;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit test for simple App.
 */
public class UserDaoTest 

{
private static final Logger logger=LoggerFactory.getLogger(UserDaoTest.class);

    @Test
    public void findUserById() throws IOException{
        BasicConfigurator.configure();
        SqlSession sqlSession = getSessionFactory().openSession();  
        UserDao userMapper = sqlSession.getMapper(UserDao.class);  
        User user = userMapper.findUserById(3);  
        logger.info("the username is {}",user.getUsername());
    }
    
    @Test
    public void findUserByName() throws IOException{
        BasicConfigurator.configure();
        SqlSession sqlSession = getSessionFactory().openSession();  
        UserDao userMapper = sqlSession.getMapper(UserDao.class);  
        User user = userMapper.findUserByName("wu");  
        logger.info("the username is {}",user.getUsername());
    }

    @Test
    public void insertUser() throws IOException{
        BasicConfigurator.configure();
        SqlSession sqlSession = getSessionFactory().openSession();  
        UserDao userMapper = sqlSession.getMapper(UserDao.class);  

        User user=new User();
        user.setUsername("wucq1");
        user.setBirthday("birthday");
        user.setSex(12);
        user.setAddress("address");
        userMapper.inserUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser() throws IOException{
        BasicConfigurator.configure();
        SqlSession sqlSession = getSessionFactory().openSession();  
        UserDao userMapper = sqlSession.getMapper(UserDao.class); 

        userMapper.deleteUserById(2);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser() {
        
        BasicConfigurator.configure();
        SqlSession sqlSession = getSessionFactory().openSession();  
        UserDao userMapper = sqlSession.getMapper(UserDao.class); 

        User user=new User();
        user.setUsername("wucq2");
        user.setBirthday("19990205");
        user.setSex(0);
        user.setAddress("bj");

        userMapper.updateUserById(user);
        sqlSession.commit();
        sqlSession.close();

    }

    
    private static SqlSessionFactory getSessionFactory() {  
        SqlSessionFactory sessionFactory = null;  
        String resource = "sqlConfig.xml";  
        try {  
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource));
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return sessionFactory;  
    }  
}
