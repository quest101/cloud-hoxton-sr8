package com.ken.mq;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.SendTo;

import javax.annotation.processing.Processor;

//@EnableBinding(value={Sink.class,SinkSender.class})
//@Slf4j
public class SinkReceiver {

   /* @StreamListener(Sink.INPUT)
    public void  receive(Object payload){
        log.info("Received："+payload);
    }*/
}
