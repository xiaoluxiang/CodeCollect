package com.lushixiang.annotationworkway.mymiddlewave;

import com.lushixiang.annotationworkway.BeanDefinitionScanner.MyMapperClassPathScanner;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class MyImportBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        // 获取PathScannerHolder注解的所有参数
        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(PathScannerHolder.class.getName());
        // 获取PathScannerHolder的value键值
        String path =(String) annotationAttributes.get("value");
        System.out.println(PathScannerHolder.class.getName());
        // 新建文件路径扫描器
        MyMapperClassPathScanner myMapperClassPathScanner = new MyMapperClassPathScanner(registry);

        // 文件路径扫描器过滤规则
        myMapperClassPathScanner.addIncludeFilter(new TypeFilter() {
            @Override
            public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
                return true;
            }
        });

        //进行扫描
        int scan = myMapperClassPathScanner.scan(path);
        // 扫描结果数
        System.out.println(scan);

//        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
//        beanDefinition.setBeanClass(MyFactoryBean.class);
//        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(UserMap.class);
//        registry.registerBeanDefinition("userMap",beanDefinition);



    }

}
