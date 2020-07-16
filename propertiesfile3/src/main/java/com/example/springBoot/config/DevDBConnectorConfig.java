package com.example.springBoot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevDBConnectorConfig implements DBConnectorConfig {

	@Override
	public String configure() {
		return "dev";
	}

}