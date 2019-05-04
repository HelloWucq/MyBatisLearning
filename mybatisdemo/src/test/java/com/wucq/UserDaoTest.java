package com.wucq;

import java.io.IOException;

import com.wucq.dao.UserDao;
import com.wucq.dao.UserDaoImpl;
import com.wucq.entity.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.BasicConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit test for simple App.
 */
public class UserDaoTest 

{
    private static final Logger logger=LoggerFactory.getLogger(UserDaoTest.class);
    private SqlSessionFactory sqlSessionFactory = null;  
    @Before
    public void setUp() throws Exception{

        BasicConfigurator.configure();
        String resource = "sqlConfig.xml";  
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource));
    }
    

    @Test
    public void findUserByIdTest() throws Exception{
        UserDao userDao=new UserDaoImpl(sqlSessionFactory);
        User user = userDao.findUserById(3);  
        logger.info("the username is {}",user.getUsername());
    }
    
    @Test
    public void findUserByNameTest() throws Exception{
        UserDao userDao=new UserDaoImpl(sqlSessionFactory);
        User user = userDao.findUserByName("wu");  
    }

    @Test
    public void insertUserTest() throws Exception{
        UserDao userDao=new UserDaoImpl(sqlSessionFactory);
        User user=new User();
        user.setUsername("wucq");
        user.setBirthday("1998526");
        user.setSex(0);
        userDao.inserUser(user);  
    }

    @Test
    public void deleteUserByIdTest() throws Exception{
        UserDao userDao=new UserDaoImpl(sqlSessionFactory);
        userDao.deleteUserById(1);  
    }

    @Test
    public void updateUserTest() throws Exception{
        UserDao userDao=new UserDaoImpl(sqlSessionFactory);
        User user=new User();
        user.setUsername("wucq");
        user.setBirthday("1998526");
        user.setSex(0);
        userDao.updateUser(user);  
    }
}
