package com.martinzou.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//测试设置代理后不开启Clash是否能够访问Gitee
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;

    private String userName;

    private String password;

    private Integer age;

    private String gender;

    private String email;

}

