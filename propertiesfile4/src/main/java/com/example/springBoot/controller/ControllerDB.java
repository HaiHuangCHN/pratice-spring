package com.example.springBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springBoot.config.DBConfig;

@RestController
public class ControllerDB {

	@Autowired
	DBConfig dbConfig;

	@RequestMapping(value = "/db", method = RequestMethod.GET)
	public String index() {

		return dbConfig.getConnectionStatus() + ": " + dbConfig.getConnectionPort() + 
		", address: "+ dbConfig.getAddress() + ", hostname: " + dbConfig.getHostname();

	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(@RequestParam String name, @RequestParam Integer sequence) {
		return "name: " + name + "sequence: " + sequence;
	}

}