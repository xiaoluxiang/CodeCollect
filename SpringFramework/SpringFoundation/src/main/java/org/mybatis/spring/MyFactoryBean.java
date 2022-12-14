package org.mybatis.spring;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
