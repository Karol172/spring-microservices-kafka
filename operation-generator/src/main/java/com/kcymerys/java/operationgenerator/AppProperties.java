package com.kcymerys.java.operationgenerator;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.topic")
@Setter
@Getter
public class AppProperties {

    private String name;

}
