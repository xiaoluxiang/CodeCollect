package com.lushixiang.springframework.postprocessor.instantiationAwareBeanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.beans.PropertyDescriptor;


public class SimplePostProcessor implements InstantiationAwareBeanPostProcessor {
    @Override
    public Object postProcessBeforeInstantiation(Class<?> aClass, String s) throws BeansException {
        System.out.println(aClass.getSimpleName()+"\npostProcessBeforeInstantiation");
        return aClass;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object o, String s) throws BeansException {
        System.out.println(o.toString()+"\npostProcessAfterInstantiation");
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues propertyValues, PropertyDescriptor[] propertyDescriptors, Object o, String s) throws BeansException {
        System.out.println("postProcessPropertyValues");
        return propertyValues;
    }


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(bean.toString()+"\npostProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(bean.toString()+"\npostProcessAfterInitialization");
        return bean;
    }
}
