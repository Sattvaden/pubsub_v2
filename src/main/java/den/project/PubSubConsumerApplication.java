package den.project;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;


@EnableBinding(Sink.class)
@SpringBootApplication
public class PubSubConsumerApplication {

    private static final Log LOGGER = LogFactory.getLog(PubSubConsumerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PubSubConsumerApplication.class, args);
    }

    @StreamListener(Sink.INPUT)
    public void handleMessage(Message<String> message) {
        LOGGER.info("Received: " + message.getPayload());
    }

}
