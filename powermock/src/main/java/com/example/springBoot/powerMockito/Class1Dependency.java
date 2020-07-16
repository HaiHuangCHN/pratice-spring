package com.example.springBoot.powerMockito;

/**
 * Created by lixiangrong on 2017/7/21.
 */

public class Class1Dependency {

	public static boolean isExist() {
		// do something
		return false;
	}

	public final boolean isAlive() {
		// do something
		return false;
	}

	public boolean isGod(String oh) {
		System.out.println(oh);
		return false;
	}
}