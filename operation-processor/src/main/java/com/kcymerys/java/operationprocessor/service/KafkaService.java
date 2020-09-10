package com.kcymerys.java.operationprocessor.service;

import com.kcymerys.java.operationprocessor.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class KafkaService {

    private final KafkaTemplate<String, Operation> kafkaTemplate;

    public void sendMessage(String topicName, Operation operation) {
        Message<Operation> msg = MessageBuilder
                .withPayload(operation)
                .setHeader(KafkaHeaders.TOPIC, topicName)
                .build();
        kafkaTemplate.send(msg);
        log.info("Message: " + operation + " has been sent to topic " + topicName);
    }

}