import com.ken.StreamApplication;
import com.ken.mq.ProducerProcessor;
import com.ken.mq.SinkSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = StreamApplication.class)
@WebAppConfiguration
public class StreamApplicationTests {

    //@Autowired
    //private SinkSender sinkSender;
    //@Autowired
    //private MessageChannel input;

    @Autowired
    private ProducerProcessor producerProcessor;

    @Test
    public void contextLoads(){

        producerProcessor.timeMessageSource();
        //sinkSender.output().send(
        //        MessageBuilder.withPayload("From SinkSender").build());
        //input.send(MessageBuilder.withPayload("From SinkSender").build());
    }

}
