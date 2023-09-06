package com.martinzou.mapper;


import com.martinzou.pojo.User;

import java.util.List;

/*
* Mybatis面向接口编程的两个一致：
* 1.映射文件的namespace要和mapper接口的全类名保持一致
* 2.映射文件SQL语句的id要和mapper接口中的方法名一致
*
* 表--实体类--mapper接口--映射文件
* */
public interface UserMapper {

    /*
    * 添加用户信息
    * */
    int insertUser();

    /*
    * 修改用户信息
    * */
    int updateUser();

    /*
    * 根据id查询用户信息
    * */
    User getUserById();

    /*
    * 查询所有的用户信息
    * */
    List<User> getAllUser();
}
