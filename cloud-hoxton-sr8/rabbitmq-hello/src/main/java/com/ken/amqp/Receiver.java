package com.ken.amqp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
//@RabbitListener(queues = "hello")
@Slf4j
public class Receiver {

    //@RabbitHandler
    @RabbitListener(queues = "hello")
    public void process(String msg){
        log.info("Recieve:{}", msg);
        System.out.println("Receiver : "+msg);
        System.out.println("=========="+msg);
    }
}
