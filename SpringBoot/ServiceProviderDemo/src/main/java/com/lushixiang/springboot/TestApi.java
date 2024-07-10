package com.lushixiang.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestApi {

    @Value("${lsx-name:lsxName}")
    private String cache;



    @RequestMapping("/testApi")
    @ResponseBody
    public String checkWebStatus(){
        return "<p>hello world and lsx-name:"+cache+"</p>";
    }

}
