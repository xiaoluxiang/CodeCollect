package com.lushixiang.bean.example;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lushixiang
 * @date 2022-12-10
 * @descriple An example Bean to be used for cycle dependent
 */
public class Teacher {
    @Autowired
    public Student student;
}
