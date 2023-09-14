package com.martinzou.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
    private Integer did;

    private String deptName;

    private List<Emp> empList;
}
