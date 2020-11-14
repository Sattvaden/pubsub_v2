package den.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;


@SpringBootApplication
public class PubSubConsumerApplication {

    private MessageHandler messageHandler;

//    @Autowired
//    public PubSubConsumerApplication(MessageHandler messageHandler) {
//        this.messageHandler = messageHandler;
//    }

    @Autowired
    public void setMessageHandler(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }

    public static void main(String[] args) {
        SpringApplication.run(PubSubConsumerApplication.class, args);
    }

    @StreamListener(MyChannel.INPUTT)
    public void handleMessage(Message<String> message) {
        messageHandler.handleMessage(message);
    }

}
