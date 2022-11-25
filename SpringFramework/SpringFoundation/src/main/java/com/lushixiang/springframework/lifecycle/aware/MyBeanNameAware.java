package com.lushixiang.springframework.lifecycle.aware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class MyBeanNameAware implements BeanNameAware {
    @Override
    public void setBeanName(String name) {
        System.out.println("MyBeanNameAware is setBeanName: " + name);
    }
}
