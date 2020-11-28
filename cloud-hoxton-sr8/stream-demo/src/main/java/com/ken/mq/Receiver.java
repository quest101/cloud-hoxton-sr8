package com.ken;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
@Slf4j
public class Receiver {

    @StreamListener(Sink.INPUT)
    public void receive(Object payload){
        log.info("Receive："+payload);
    }
}
