package com.example.springBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springBoot.config.DBConfig;

@RestController
public class ControllerDB {

	@Autowired
	DBConfig dbConfig;

	@RequestMapping(value = "/db")
	public String index() {

		return dbConfig.getConnectionStatus() + " : " + dbConfig.getConnectionPort();

	}

}