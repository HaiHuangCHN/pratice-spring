//package com.demo.consumingarestfulwebservice;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.web.client.RestTemplate;
//
//public class Application {
//
//	private static final Logger log = LoggerFactory.getLogger(Application.class);
//
//	public static void main(String args[]) {
//		RestTemplate restTemplate = new RestTemplate();
//		Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
//		log.info(quote.toString());
//	}
//
//}
//
//12:01:45.377 [main] DEBUG org.springframework.web.client.RestTemplate - Created GET request for "http://gturnquist-quoters.cfapps.io/api/random"
//12:01:45.456 [main] DEBUG org.springframework.web.client.RestTemplate - Setting request Accept header to [application/json, application/*+json]
//12:01:46.096 [main] DEBUG org.springframework.web.client.RestTemplate - GET request for "http://gturnquist-quoters.cfapps.io/api/random" resulted in 200 (OK)
//12:01:46.098 [main] DEBUG org.springframework.web.client.RestTemplate - Reading [class com.demo.consumingarestfulwebservice.Quote] as "application/json;charset=UTF-8" using [org.springframework.http.converter.json.MappingJackson2HttpMessageConverter@400cff1a]
//12:01:46.112 [main] INFO com.demo.consumingarestfulwebservice.Application - Quote{type='success', value=Value{id=11, quote='I have two hours today to build an app from scratch. @springboot to the rescue!'}}

package com.demo.consumingarestfulwebservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String args[]) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
			log.info(quote.toString());
		};
	}
}