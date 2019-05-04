package com.wucq;

import java.util.ArrayList;
import java.util.List;

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
 * BatchTest
 */
public class BatchTest {

    private static final Logger logger=LoggerFactory.getLogger("CacheTest.class");
    private SqlSessionFactory sqlSessionFactory = null;  

    @Before
    public void setUp() throws Exception{

        BasicConfigurator.configure();
        String resource = "sqlConfig.xml";  
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource));
    }

    @Test
    public void BatchTest1() throws Exception {
        
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserDao userDao=sqlSession.getMapper(UserDao.class);
        List<User>list=new ArrayList<>();

        list.add(new User(5,"wucq5","19940325",1,"dl"));
        list.add(new User(6,"wucq6","19940326",1,"tj"));
        list.add(new User(7,"wucq7","19940327",1,"hf"));
        list.add(new User(8,"wucq8","19940328",1,"ah"));
        list.add(new User(9,"wucq9","19940329",1,"he"));
        list.add(new User(10,"wucq10","19940330",1,"gd"));

        int total=userDao.saveUserBatch(list);
        logger.info("total is {}",total);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void BatchTest2() throws Exception {
        
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserDao userDao=sqlSession.getMapper(UserDao.class);
        List<Integer>list=new ArrayList<>();

        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);

        int total=userDao.delUserBatch(list);
        logger.info("total is {}",total);
        sqlSession.commit();
        sqlSession.close();
    }
}


