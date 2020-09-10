package com.kcymerys.java.operationgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Random;

@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling
@EnableConfigurationProperties(AppProperties.class)
public class OperationGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(OperationGeneratorApplication.class, args);
    }

    @Bean
    public Random random() {
        return new Random();
    }

}
