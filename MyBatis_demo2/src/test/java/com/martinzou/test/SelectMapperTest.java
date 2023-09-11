package com.martinzou.test;

import com.martinzou.mapper.SelectMapper;
import com.martinzou.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class SelectMapperTest {
    /*
    * MyBatis的各种查询功能：
    * 1、若查询出的数据只有一条，可以通过实体类对象或者list和map集合接收
    * map集合的结果{password=123456, user_name=张三, sex=男, id=3, age=23, email=123456@qq.com}
    * 2、若查询出的数据有多条，一定不能通过实体类对象接受，此时会抛出异常TooManyResultsException
    * 3、多条数据可以通过list集合进行接收
    * 4、多条数据可以用list<map<String,Object>>来进行接收
    * 5、也可以再mapper接口的方法上天机@MapKey注解，此时就可以将每条数据转换的map集合为值
    * 以某个字段的值作为键，放在同一个map集合中
    * */

    @Test
    public void testGetUserById(){
        SqlSession sqlSession=SqlSessionUtils.getSqlSession();
        SelectMapper mapper=sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserById(3));

    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession=SqlSessionUtils.getSqlSession();
        SelectMapper mapper=sqlSession.getMapper(SelectMapper.class);
        mapper.getUserList().forEach(user -> System.out.println(user));
    }



     /**
     * 查询用户的总记录数
     * @return
     * 在MyBatis中，对于Java中常用的类型都设置了类型别名
     * 例如：java.lang.Integer-->int|integer
     * 例如：int-->_int|_integer
     * 例如：Map-->map,List-->list
     */
    @Test
    public void testGetCount(){
        SqlSession sqlSession=SqlSessionUtils.getSqlSession();
        SelectMapper mapper=sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getCount());
    }
    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession=SqlSessionUtils.getSqlSession();
        SelectMapper mapper=sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserByIdToMap(3));
    }

    @Test
    public void testGetAllUserToMap(){
        SqlSession sqlSession=SqlSessionUtils.getSqlSession();
        SelectMapper mapper=sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUserToMap());
    }


}
