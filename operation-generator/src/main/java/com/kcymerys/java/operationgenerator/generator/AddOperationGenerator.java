package com.kcymerys.java.operationgenerator.generator;

import com.kcymerys.java.operationgenerator.AppProperties;
import com.kcymerys.java.operationgenerator.KafkaService;
import com.kcymerys.java.operationgenerator.Operation;
import com.kcymerys.java.operationgenerator.OperationType;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Profile("add")
@Component
@AllArgsConstructor
@Slf4j
public class AddOperationGenerator implements OperationGenerator {

    private final Random random;
    private final KafkaService kafkaService;
    private final AppProperties appProperties;

    @Override
    @Scheduled(fixedDelayString = "${app.event.interval}")
    public void generateOperation() {
        Operation operation = new Operation(random.nextGaussian(), random.nextGaussian(), OperationType.ADDITION);
        log.info("Generated operation: " + operation);
        kafkaService.sendMessage(appProperties.getName(), operation);
    }

}
