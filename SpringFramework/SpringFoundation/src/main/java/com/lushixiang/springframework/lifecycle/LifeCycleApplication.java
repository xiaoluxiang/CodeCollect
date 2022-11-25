package com.lushixiang.springframework.lifecycle;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class LifeCycleApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.lushixiang.springframework.lifecycle");
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);
    }
}


