package com.martinzou.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    private Integer eid;

    private String empName;

    private Integer age;

    private String gender;

    private String email;

    private Dept dept;

}
