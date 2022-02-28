package dev.marco.demokafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Value("${app.topic.name}")
    private String TOPIC_NAME;

    @Autowired
    private KafkaTemplate<Object, Object> template;

    /**
     * We create a rest controller that receive a text and forward it to kafka
     */

    @PostMapping(path = "/send/message/{text}")
    public void sendFoo(@PathVariable String text) {
        this.template.send(TOPIC_NAME, text);
    }

}
