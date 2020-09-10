package com.kcymerys.java.operationprocessor.service;

import com.kcymerys.java.operationprocessor.Operation;
import com.kcymerys.java.operationprocessor.TopicProperties;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("sub")
@Service
@AllArgsConstructor
public class SubOperationService implements OperationService {

    private final KafkaService kafkaService;
    private final TopicProperties topicProperties;

    @Override
    public void perform(Operation operation) {
        operation.setResult(operation.getArg1() - operation.getArg2());
        kafkaService.sendMessage(topicProperties.getName(), operation);
    }

}