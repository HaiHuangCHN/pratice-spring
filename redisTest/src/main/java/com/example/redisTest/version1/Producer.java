package com.example.redisTest.version1;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {

	private volatile boolean isRunning = true;
	private BlockingQueue<PCData> queue;// 内存缓冲区
	private static AtomicInteger count = new AtomicInteger();// 总数 原子操作
	private static final int SLEEPTIME = 1000;

	public Producer(BlockingQueue<PCData> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		PCData data = null;
		Random random = new Random();
		System.out.println("start producting id:" + Thread.currentThread().getId());

		try {
			while (isRunning) {
				Thread.sleep(random.nextInt(SLEEPTIME));
				data = new PCData(count.incrementAndGet());
				System.out.println(data + "加入队列");
				if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
					System.out.println("加入队列失败");
				}

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void stop() {
		isRunning = false;
	}

}
