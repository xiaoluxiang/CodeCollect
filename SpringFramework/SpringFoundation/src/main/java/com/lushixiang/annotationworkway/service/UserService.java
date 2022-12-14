package com.lushixiang.annotationworkway.service;

import com.lushixiang.annotationworkway.mapper.OrderMap;
import com.lushixiang.annotationworkway.mapper.UserMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    UserService(){
        System.out.println("UserService is construct...");
    }

    @Autowired
    private UserMap userMap;
    @Autowired
    private OrderMap orderMap;


    public void test(){
        userMap.selectById();
        orderMap.test();
    }
}
