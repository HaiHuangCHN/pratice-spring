package com.example.redisTest.version1;

public class PCData {

	private final int InitData;

	public PCData(int initData) {
		InitData = initData;
	}

	public PCData(String d) {
		InitData = Integer.valueOf(d);
	}

	public int getInitData() {
		return InitData;
	}

	@Override
	public String toString() {
		return "PCData{" + "InitData=" + InitData + '}';
	}
}
