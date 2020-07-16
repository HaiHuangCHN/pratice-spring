package com.example.springBoot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "com.db")
public class DBConfig {

	private String connectionStatus;
	private String connectionPort;

	public String getConnectionStatus() {
		return connectionStatus;
	}

	public String getConnectionPort() {
		return connectionPort;
	}

	public void setConnectionStatus(String connectionStatus) {
		this.connectionStatus = connectionStatus;
	}

	public void setConnectionPort(String connectionPort) {
		this.connectionPort = connectionPort;
	}

}
