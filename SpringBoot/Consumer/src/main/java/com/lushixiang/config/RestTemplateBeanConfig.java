package com.lushixiang.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateBeanConfig {
    @Bean
//    @LoadBalanced
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
