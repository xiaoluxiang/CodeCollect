package com.lushixiang.annotationworkway;

import com.lushixiang.annotationworkway.mymiddlewave.PathScannerHolder;
import com.lushixiang.annotationworkway.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


/**
 * 本类演示了，如何通过自定义注解完成自定义注解的功能
 * 通过自定义注解+自定义
 */
@ComponentScan("com.lushixiang.annotationworkway.service")
@PathScannerHolder("com.lushixiang.annotationworkway.mapper")
public class AnnotationWorkWayApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(AnnotationWorkWayApplication.class);
        System.out.println("old ApplicationContext is ready ...");
        annotationConfigApplicationContext.refresh();

        System.out.println("new ApplicationContext is ready ...");
        UserService userService = annotationConfigApplicationContext.getBean("userService", UserService.class);
        userService.test();


    }
}
