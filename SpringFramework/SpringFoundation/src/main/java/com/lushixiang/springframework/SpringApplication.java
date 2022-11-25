package com.lushixiang.springframework;


import com.lushixiang.springframework.postprocessor.instantiationAwareBeanPostProcessor.SimplePostProcessor;
import com.lushixiang.springframework.postprocessor.instantiationAwareBeanPostProcessor.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.Arrays;

@Import({SimplePostProcessor.class, User.class})
public class SpringApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringApplication.class);
        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);

    }
}
