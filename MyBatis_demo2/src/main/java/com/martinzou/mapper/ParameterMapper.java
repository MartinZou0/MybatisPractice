package com.martinzou.mapper;

import com.martinzou.pojo.User;
import org.apache.ibatis.annotations.Param;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;

public interface ParameterMapper {

    /*
    *
    * 添加用户信息
    * */
    int insertUser(User user);


    /*
    * 根据用户名查询用户信息
    * */
    User getUserByName(String userName);

    List<User> getAllUser();

    /*
    * 验证登录
    * */
    User checkLogin(String username,String password);

    User checkLoginByMap(Map<String,Object>map);


    User checkLoginByParam(@Param("name") String userName, @Param("pwd") String password);
}
