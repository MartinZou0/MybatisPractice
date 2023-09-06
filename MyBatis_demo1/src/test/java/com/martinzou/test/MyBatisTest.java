package com.martinzou.test;

import com.martinzou.mapper.UserMapper;
import com.martinzou.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    @Test
    public void testMyBatis() throws IOException {
        //加载核心配置文件
        InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(is);
        //获取sqlsession
        //通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都必须手动提交或回滚事务
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交,默认不自动提交事务
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        //获取mapper接口对象()  getMapper方法的底层创建了userMapper的实现类并返回实现类的对象
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        //测试功能，此时显示result1但是数据库没变，因为配置文件中使用jdbc来管理事务，所以需要进行提交
        int result=mapper.insertUser();
        //提交事务
        //sqlSession.commit();
        System.out.println("result"+result);
    }

    @Test
    public void testUpdate() throws IOException {
        //加载核心配置文件
        InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(is);
        //获取sqlsession
        //通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都必须手动提交或回滚事务
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交,默认不自动提交事务
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        //获取mapper接口对象()  getMapper方法的底层创建了userMapper的实现类并返回实现类的对象
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        //测试功能，此时显示result1但是数据库没变，因为配置文件中使用jdbc来管理事务，所以需要进行提交
        mapper.updateUser();
    }

    @Test
    public void testCRUD() throws IOException {
        InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        //mapper.updateUser();
        //System.out.println(mapper.getUserById().toString());
        List<User>list=mapper.getAllUser();
        list.forEach(user -> System.out.println(user));
    }
}
