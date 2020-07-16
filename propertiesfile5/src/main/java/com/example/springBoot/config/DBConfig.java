package com.example.springBoot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBConfig {

	private static String connectionStatus;
	@Value("${com.db.connection-port}")
	private String connectionPort;

	public String getConnectionStatus() {
		return connectionStatus;
	}

	public String getConnectionPort() {
		return connectionPort;
	}

	@Value("${com.db.connection-status}")
	public void setConnectionStatus(String connectionStatus) {
		DBConfig.connectionStatus = connectionStatus;
	}

	public void setConnectionPort(String connectionPort) {
		this.connectionPort = connectionPort;
	}

}
