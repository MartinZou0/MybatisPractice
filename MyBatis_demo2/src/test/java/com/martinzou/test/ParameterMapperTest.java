package com.martinzou.test;

import com.martinzou.mapper.ParameterMapper;
import com.martinzou.pojo.User;
import com.martinzou.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParameterMapperTest {

    /*
    * MyBatis获取参数的两种方式：
    * ${}本质字符串拼接
    * #{}本质占位符赋值--推荐
    * Mybatis获取参数值的各种情况：
    * 1.mapper接口方法的参数为单个的字面量类型，此时可以使用${}和#{}以任意的名称（最好见名识意）获取参数的值
    * 注意${}需要手动加单引号
    * 2.若mapper接口中的方法参数为多个时，
    * 此时MyBatis会自动将这些参数放在一个map集合中
        a>. 以arg0,arg1...为键，以参数为值；
        b>. 以param1,param2...为键，以参数为值；
      因此只需要通过#{}${}以键的方式访问值即可
    *3.Map集合类型的参数,若mapper接口方法的参数有多个时，可以手动将这些参数放在一个map中存储
    *4.mapper接口方法的参数是实体类类型的参数
    * 此时可以使用${}和#{}，通过访问实体类对象中的属性名获取属性值，注意${}需要手动加单引号
    *
    * 5.使用@Param标识参数
    * 可以通过@Param注解标识mapper接口中的方法参数
此时，会将这些参数放在map集合中，以@Param注解的value属性值为键，以参数为值；以
param1,param2...为键，以参数为值；只需要通过${}和#{}访问map集合的键就可以获取相对应的值，
注意${}需要手动加单引号
    *
    * */
    @Test
    public void testCheckLoginByParam() throws IOException {
        SqlSession sqlSession=SqlSessionUtils.getSqlSession();
        ParameterMapper mapper=sqlSession.getMapper(ParameterMapper.class);
        System.out.println(mapper.checkLoginByParam("张三","123456"));
        sqlSession.close();
    }




    @Test
    public void testInsertUser() throws IOException {
        SqlSession sqlSession=SqlSessionUtils.getSqlSession();
        ParameterMapper mapper=sqlSession.getMapper(ParameterMapper.class);
        User user=new User();
        user.setUserName("李四");
        user.setAge(23);
        user.setGender("男");
        user.setEmail("123@qq.com");
        System.out.println(mapper.insertUser(user));
    }

    @Test
    public void testgetUserByName() throws IOException {
        SqlSession sqlSession=SqlSessionUtils.getSqlSession();
        ParameterMapper mapper=sqlSession.getMapper(ParameterMapper.class);
        User user=mapper.getUserByName("张三");
        System.out.println(user);
    }


    /*
    * 若mapper接口中的方法参数为多个时，
    * 此时MyBatis会自动将这些参数放在一个map集合中
        1. 以arg0,arg1...为键，以参数为值；
        2. 以param1,param2...为键，以参数为值；
    * */
    @Test
    public void testCheckLogin() throws IOException {
        SqlSession sqlSession=SqlSessionUtils.getSqlSession();
        ParameterMapper mapper=sqlSession.getMapper(ParameterMapper.class);
        User user=mapper.checkLogin("张三","123456");
        System.out.println(user);
    }

    @Test
    public void testCheckLoginByMap() throws IOException {
        SqlSession sqlSession=SqlSessionUtils.getSqlSession();
        ParameterMapper mapper=sqlSession.getMapper(ParameterMapper.class);
        Map<String,Object>map=new HashMap<>();
        map.put("userName","张三");
        map.put("password","123456");
        User user=mapper.checkLoginByMap(map);
        System.out.println(user);
    }


    @Test
    public void testgetAllUser() throws IOException {
        SqlSession sqlSession=SqlSessionUtils.getSqlSession();
        ParameterMapper mapper=sqlSession.getMapper(ParameterMapper.class);
        List<User> list=mapper.getAllUser();
        list.forEach(user -> System.out.println(user));
    }

    @Test
    public void testJDBC() throws Exception{
        String userName="admin";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection=DriverManager.getConnection("","","");
        //字符串拼接的方式
        //PreparedStatement ps=connection.prepareStatement("select * from t_user where user_name='"+userName+"'");
        //占位符方式
        PreparedStatement ps=connection.prepareStatement("select * from t_user where user_name= ?");
        //为SQL语句中的占位符进行赋值。
        //第一个参数是占位符的位置，第二参数为内容
        ps.setString(1,userName);


    }
}
