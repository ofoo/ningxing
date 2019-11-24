package com.guoguo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "ningxing")
@PropertySource(value = "classpath:project.properties")
@Data
public class ProjectProperties {
    private String fileRoot;
}
