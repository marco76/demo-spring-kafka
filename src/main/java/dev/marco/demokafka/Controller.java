package dev.marco.demokafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final KafkaTemplate<Object, Object> template;

    public Controller(KafkaTemplate<Object, Object> template) {
        this.template = template;
    }

    @Value("${app.topic.name}")
    private String topicName;

    /**
     * We create a REST controller that receives a text and forward it to kafka
     */
    @PostMapping(path = "/send/message/{text}")
    public void sendFoo(@PathVariable String text) {
        this.template.send(topicName, text);
    }

}
