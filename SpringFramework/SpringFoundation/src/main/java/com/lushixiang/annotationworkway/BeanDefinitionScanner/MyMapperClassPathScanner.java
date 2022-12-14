package com.lushixiang.annotationworkway.BeanDefinitionScanner;

import org.mybatis.spring.MyFactoryBean;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Objects;
import java.util.Set;

public class MyMapperClassPathScanner extends ClassPathBeanDefinitionScanner {


    public MyMapperClassPathScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return beanDefinition.getMetadata().isInterface();
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        // scan 出来会得到BeanDefinitionHolders，针对这些BeanDefinition进行FactoryBean注册成为SpringBean
        Set<BeanDefinitionHolder> beanDefinitionHolders = super.doScan(basePackages);
        for (BeanDefinitionHolder beanDefinitionHolder : beanDefinitionHolders) {
            BeanDefinition beanDefinition = beanDefinitionHolder.getBeanDefinition();

            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(Objects.requireNonNull(beanDefinition.getBeanClassName()));
            beanDefinition.setBeanClassName(MyFactoryBean.class.getName());
        }
        return beanDefinitionHolders;
    }
}
