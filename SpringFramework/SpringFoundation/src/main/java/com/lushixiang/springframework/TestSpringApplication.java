package com.lushixiang.springframework;


import com.lushixiang.springframework.postprocessor.instantiationAwareBeanPostProcessor.SimplePostProcessor;
import com.lushixiang.springframework.postprocessor.instantiationAwareBeanPostProcessor.User;
import org.mybatis.spring.MyFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.Arrays;


@Import({SimplePostProcessor.class, User.class, MyFactoryBean.class})
public class TestSpringApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestSpringApplication.class);
        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);

    }
}
