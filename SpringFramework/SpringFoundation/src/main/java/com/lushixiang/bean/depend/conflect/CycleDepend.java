package com.lushixiang.bean.depend.conflect;

import com.lushixiang.bean.example.Student;
import com.lushixiang.bean.example.Teacher;
import com.lushixiang.bean.middle.MyBeanProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * @author lushixiang
 * @date 2022-12-10
 * @descriple An application shows processor cause filed dependent error
 * @conclusion BeanPostProcessor 会导致Bean循环依赖出现问题，也不是绝对的，会看Bean实现顺序。
 */
@Import({Student.class,  Teacher.class, MyBeanProcessor.class})
public class CycleDepend {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(CycleDepend.class);
        System.out.println(applicationContext.getBean(Teacher.class));
        Student bean = applicationContext.getBean(Student.class);
        System.out.println(bean.teacher);
        System.out.println("1213");
    }
}
