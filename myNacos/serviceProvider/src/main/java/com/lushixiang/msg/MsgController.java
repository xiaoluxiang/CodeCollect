package com.lushixiang.msg;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
public class MsgController {
    @RequestMapping("/queryMsg")
    public String queryMsg(@RequestParam ("name") String name){
        return name+"8001";
    }
}
