package con.ken.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "hello-service")
public interface HelloService {

    @RequestMapping("/api/ribbon/index")
    String hello();
}
