package com.lushixiang.springframework.lifecycle.config;

import com.lushixiang.springframework.lifecycle.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean(name = "user", initMethod = "doInit", destroyMethod = "doDestroy")
    public User create() {
        User user = new User();
        user.setName("lushixiang");
        user.setAge(24);
        return user;
    }
}