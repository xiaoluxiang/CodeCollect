package lushixiang.msg;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.List;

;

@RestController
public class MsgConsumer {

    @Resource
    private RestTemplate restTemplate;

    @NacosInjected
    NamingService namingService;

    @RequestMapping("/consumer")
    public String consumer(){
        System.out.println("======>>>>>>>");
        return restTemplate.getForObject(  "http://provider/queryMsg?name=lushixiang", String.class);
    }

    @GetMapping("/name")
    public List<Instance> getService(@PathParam("serviceName") String name ) throws NacosException {
        List<Instance> allInstances = namingService.getAllInstances(name);
        allInstances.forEach(all->{
            System.err.println(all.getIp());    //ip
            System.err.println(all.getPort());  //端口
        });
        return allInstances;
    }
    @Value("${myName}")
    private String myName;

    @RequestMapping("/name")
    private String getConfig(){
        System.out.println(myName);
        return myName;
    }
}
