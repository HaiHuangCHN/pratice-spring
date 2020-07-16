package com.example.springBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springBoot.config.UserConfigBoy;
import com.example.springBoot.config.UserConfigGirl;

@RestController
public class Controller {

	@Autowired
	UserConfigBoy userConfigHuang;

	@RequestMapping(value = "/huang")
	public String indexHuang() {
		return userConfigHuang.getName() + ": " + userConfigHuang.getWords();
	}

	@Autowired
	UserConfigGirl userConfigZeng;

	@RequestMapping(value = "/liu")
	public String indexZeng() {
		return userConfigZeng.getName() + ": " + userConfigZeng.getWords();
	}

}
