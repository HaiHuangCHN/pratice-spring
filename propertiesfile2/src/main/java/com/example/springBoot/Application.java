package com.example.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.springBoot.config.UserConfigBoy;
import com.example.springBoot.config.UserConfigGirl;

@SpringBootApplication
@EnableConfigurationProperties({ UserConfigBoy.class, UserConfigGirl.class })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
