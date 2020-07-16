package com.example.springBoot.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "com.db")
public class DBConfig {

	private String connectionStatus;
	private String connectionPort;
	private String address;
	private Map<String, String> hostname = new HashMap<String, String>();

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Map<String, String> getHostname() {
		return hostname;
	}

	public void setHostname(Map<String, String> hostname) {
		this.hostname = hostname;
	}

}
