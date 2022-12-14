package com.lushixiang.bean.middle;

import com.lushixiang.bean.example.Student;
import com.lushixiang.bean.example.Teacher;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyBeanProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName);
        if("com.lushixiang.bean.example.Teacher".equals(beanName)){
            Teacher teacher = new Teacher();
            System.out.println("替换"+bean+"---->"+teacher);
            return teacher;
        }
        if("com.lushixiang.bean.example.Student".equals(beanName)){
            Student bean1 = (Student) bean;
            System.out.println("student's teacher:"+bean1.teacher);
        }
        return bean;
    }
}
