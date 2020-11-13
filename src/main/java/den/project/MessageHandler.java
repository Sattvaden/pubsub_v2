package den.project;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageHandler {

    private static final Log LOGGER = LogFactory.getLog(MessageHandler.class);

    public void handleMessage(Message<String> message) {
        LOGGER.info("Received: " + message.getPayload());
    }
}
