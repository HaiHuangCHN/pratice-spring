package com.example.springBoot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "com.user1") // Overall configuration
@PropertySource("classpath:boy.properties")
public class UserConfigBoy {

//	@Value("${com.user1.name}")// Specified configuration
	private String name;
//	@Value("${com.user1.words}")// Specified configuration
	private String words;

	public String getName() {
		return name;
	}

	public String getWords() {
		return words;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setWords(String words) {
		this.words = words;
	}

}
