package con.ken.service;

import con.ken.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(value = "hello-service")
public interface HelloService {

//    @RequestMapping("/api/ribbon/index")
//    String hello();
//
//    @RequestMapping("/api/ribbon/index1")
//    String hello(@RequestParam("name") String name);
//
//    @RequestMapping("/api/ribbon/index2")
//    String hello(@RequestHeader("name") String name,
//                 @RequestHeader("age") Integer age);
//
//    @RequestMapping("/api/ribbon/index3")
//    String hello(@RequestBody User user);
}
