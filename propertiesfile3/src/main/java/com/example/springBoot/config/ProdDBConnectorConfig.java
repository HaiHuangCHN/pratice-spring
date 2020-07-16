package com.example.springBoot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ProdDBConnectorConfig implements DBConnectorConfig {

	@Override
	public String configure() {
		return "prod";
	}

}
