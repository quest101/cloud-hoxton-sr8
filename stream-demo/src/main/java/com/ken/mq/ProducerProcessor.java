package com.ken.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import java.util.Date;


@EnableBinding(value={Processor.class})
@Slf4j
public class ProducerProcessor {

    @Bean
    @InboundChannelAdapter(value=Processor.OUTPUT,
            poller = @Poller(fixedDelay = "2000"))
    public MessageSource timeMessageSource(){
        return () -> new GenericMessage<>(new Date());
    }


    @StreamListener(Processor.INPUT)
    public void receiveFromOutput(Object payload){
        log.info("Receive："+payload);
    }
}
