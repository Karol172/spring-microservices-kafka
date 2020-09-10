package com.kcymerys.java.operationprocessor;

import com.kcymerys.java.operationprocessor.service.OperationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class MessageListener {

    private final OperationService operationService;

    @KafkaListener(topics = "${app.input-topic.name}", groupId = "${spring.profiles.active}")
    public void receiveOperation(@Payload Operation operation) {
        log.info("Received message: " + operation);
        operationService.perform(operation);
    }

}
