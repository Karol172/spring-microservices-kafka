package com.kcymerys.java.operationgenerator.generator;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

public interface OperationGenerator {

    void generateOperation();

}
