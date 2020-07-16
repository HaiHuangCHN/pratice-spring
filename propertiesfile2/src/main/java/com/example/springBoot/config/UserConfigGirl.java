package com.example.springBoot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "com.user2")
@PropertySource("classpath:girl.properties")
public class UserConfigGirl {

//	@Value("${com.user2.name}")// Specified configuration
	private String name;
//	@Value("${com.user2.words}")// Specified configuration
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
