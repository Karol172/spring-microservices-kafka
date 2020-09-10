package com.kcymerys.java.operationprocessor.service;

import com.kcymerys.java.operationprocessor.Operation;
import com.kcymerys.java.operationprocessor.TopicProperties;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("div")
@Service
@AllArgsConstructor
@Slf4j
public class DivOperationService implements OperationService {

    private final KafkaService kafkaService;
    private final TopicProperties topicProperties;

    @Override
    public void perform(Operation operation) {
        if (operation.getArg2() - 0.0 < 0.000001) {
            log.error("Illegal Operation: division by zero");
        } else {
            operation.setResult(operation.getArg1() / operation.getArg2());
            kafkaService.sendMessage(topicProperties.getName(), operation);
        }
    }

}
