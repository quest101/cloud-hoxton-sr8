package com.ken.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.SendTo;


@EnableBinding(value={Processor.class})
@Slf4j
public class ReceiverProcessor {

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Object receive(Object payload){
        log.info("Receive："+payload);
        return "From Input Channel Return - " + payload;
    }
}
