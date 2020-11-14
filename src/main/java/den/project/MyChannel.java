package den.project;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface MyChannel {

    String PUBSUB = "pubsub";

    @Input(PUBSUB)
    MessageChannel input();
}
