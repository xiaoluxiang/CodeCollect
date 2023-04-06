package org.mybatis.spring;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * FactoryBean是一个Spring的Bean，只不过这个Bean比较特殊
 * 从SpringContext中获取该Bean时，获得的到的是该Bean中getObject方法的返回值。如果需要获取其本身需要增加&
 * */
@Configuration
public class MyFactoryBean implements FactoryBean {

    private Class mapperClass;

    public  MyFactoryBean(Class mapperClass) {
        this.mapperClass = mapperClass;
    }

    @Override
    public Object getObject() throws Exception {
        Object o = Proxy.newProxyInstance(MyFactoryBean.class.getClassLoader(), new Class[]{mapperClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                System.out.println(method.getName()+" is running");
                return null;
            }
        });
        return o;
    }

    @Override
    public Class<?> getObjectType() {
        return mapperClass;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
