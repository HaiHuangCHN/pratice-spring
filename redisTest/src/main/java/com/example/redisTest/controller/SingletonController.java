package com.example.redisTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.redisTest.singleton.Singleton5;

@Controller
public class SingletonController {

	class TestThread implements Runnable {

		@Override
		public void run() {

			int hash = Singleton5.getInstance5().hashCode();
			System.out.println(hash);

		}
	}

	@RequestMapping("/testSingleton")
	public void testSingleton() {

		Thread[] threads = new Thread[10];
		for (int i = 0; i < threads.length; i++) {
			TestThread testThread = new TestThread();
			threads[i] = new Thread(testThread);
			threads[i].start();
		}
	}

}
