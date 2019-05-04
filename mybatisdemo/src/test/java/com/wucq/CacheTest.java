package com.wucq;

import java.io.IOException;

import com.wucq.dao.UserDao;
import com.wucq.entity.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.BasicConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CacheTest1
 */
public class CacheTest {
    private static final Logger logger=LoggerFactory.getLogger("CacheTest.class");
    private SqlSessionFactory sqlSessionFactory = null;  

    @Before
    public void setUp() throws Exception{

        BasicConfigurator.configure();
        String resource = "sqlConfig.xml";  
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource));
    }

    @Test
    public void cacheTest1() throws Exception{
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserDao userDao=sqlSession.getMapper(UserDao.class);

        User user1=userDao.findUserById(3);
        logger.info("user is {}",user1.getUsername());

        user1.setUsername("wuchenqi");
        userDao.updateUser(user1);
        sqlSession.commit();

        User user2=userDao.findUserById(3);
        logger.info("user is {}",user2.getUsername());

        sqlSession.close();
    }

    @Test
    public void cacheTest2() throws Exception{
        SqlSession sqlSession1=sqlSessionFactory.openSession();
        
        UserDao userDao=sqlSession1.getMapper(UserDao.class);
        User user1=userDao.findUserById(3);
        logger.info("user1 is {}",user1.getUsername());
        try {
            sqlSession1.close();
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        
        SqlSession sqlSession3=sqlSessionFactory.openSession();
        UserDao userDao2=sqlSession3.getMapper(UserDao.class);
        User user2=userDao2.findUserById(3);
        logger.info("user2 is {}",user2.getUsername());
        user2.setUsername("wucq");
        userDao2.updateUser(user2);
        sqlSession3.commit();
        try {
            sqlSession3.close();
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }        

        SqlSession sqlSession2=sqlSessionFactory.openSession();
        UserDao userDao3=sqlSession2.getMapper(UserDao.class);
        User user3=userDao3.findUserById(3);
        logger.info("user3 is {}",user3.getUsername());
        try {
            sqlSession2.close();
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }      
        
    }
}