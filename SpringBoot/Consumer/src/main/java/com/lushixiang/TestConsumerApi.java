package com.lushixiang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class TestConsumerApi {
    @Resource
    RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancer;
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/testConsumerApi")
    public String testConsumerApiStatus(){
        System.out.println("lsx down"+loadBalancer.choose("test-consul"));
        System.out.println("lsx down"+loadBalancer.choose("test-consul").getUri().toString());
        ExchangeMessage forObject = restTemplate.getForObject(loadBalancer.choose("test-consul").getUri().toString() + "/testProviderApi", ExchangeMessage.class);
//        ExchangeMessage forObject = restTemplate.getForObject("http://localhost:9999/testProviderApi", ExchangeMessage.class);
        return "Consumer receive ..." + forObject.getType()+":"+forObject.getMessage();
    }

    @RequestMapping("/actuator/health")
    public String errorHandler1111(){
        return "error happen forget this...";
    }
}
