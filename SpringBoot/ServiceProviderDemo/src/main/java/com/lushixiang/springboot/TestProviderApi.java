package com.lushixiang.springboot;

import com.lushixiang.ExchangeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestProviderApi {

    @Value("${server.port}")
    int port;
    @RequestMapping("/testProviderApi")
    public ExchangeMessage testProviderApiMethod(){
        ExchangeMessage exchangeMessage = new ExchangeMessage();
        exchangeMessage.setMessage("hello I am provider ..."+port);
        exchangeMessage.setType("hello");
        return exchangeMessage;
    }

    @RequestMapping("/actuator/health")
    public String errorHandler1111(){
        return "error happen forget this...";
    }
}
