package com.example.springBoot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "com.db")
public interface DBConnectorConfig {
	public String configure();

}