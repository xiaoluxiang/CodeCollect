package com.lushixiang.bean.example;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lushixiang
 * @date 2022-12-10
 * @descriple An example Bean to be used
 */
public class Student {

    static{
        System.out.println("Student is load...");
    }

    @Autowired
    public Teacher teacher;
}
