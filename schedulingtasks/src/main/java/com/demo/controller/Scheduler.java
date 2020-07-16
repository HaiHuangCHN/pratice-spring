package com.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
	private static final Logger log = LoggerFactory.getLogger(Scheduler.class);
	private static final SimpleDateFormat DATEFORMAT = new SimpleDateFormat("HH:mm:ss");

//	@Scheduled(initialDelay = 6000, fixedRate = 6000)
//	public void reportCurrentTime() {
//		log.info("The time is now {}", DATEFORMAT.format(new Date()));
//	}

	@Scheduled(cron = "0 55/55 * * * ?")
	public void reportCurrentTime2() {
		log.info("The time is now {}", DATEFORMAT.format(new Date()));
	}
	
}
