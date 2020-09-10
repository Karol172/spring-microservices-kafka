package com.kcymerys.java.operationprocessor;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.output-topic")
@Setter
@Getter
public class TopicProperties {

    private String name;

}


