package con.ken.controller;

import com.ken.dto.User;
import con.ken.service.RefactorHelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/feign")
public class ConsumerController {

    private final static Logger logger = LoggerFactory.getLogger(ConsumerController.class);

   // @Autowired
    //HelloService1 helloService;
//
    @Autowired
    RefactorHelloService refactorHelloService;

/*    @GetMapping("/hello")
    public String helloConsumer(){
        return "HELLO WORLD";
    }*/
//
//    //@RequestMapping(value = "/feign-consumer",method = RequestMethod.GET)
//    @GetMapping("/feign-consumer")
//    public String helloConsumer(){
//        return helloService.hello();
//    }
//
//    @GetMapping("/feign-consumer2")
//    public String helloConsumer2(){
//        StringBuilder sb = new StringBuilder();
//        sb.append(helloService.hello()).append("\n");
//        sb.append(helloService.hello("DIDI")).append("\n");
//        sb.append(helloService.hello("DIDI",18)).append("\n");
//        sb.append(helloService.hello(new User("DIDI",18))).append("\n");
//        return sb.toString();
//    }

    @GetMapping("/consumer")
    public String helloConsumer3(){
        logger.info("==============feign-consumer============");
        StringBuilder sb = new StringBuilder();
        //sb.append(helloService.hello()).append("\n");
        sb.append(refactorHelloService.hello("DIDI")).append("\n");
        sb.append(refactorHelloService.hello("DIDI",18)).append("\n");
        sb.append(refactorHelloService.hello(new User("DIDI",18))).append("\n");
        return sb.toString();
    }
}
