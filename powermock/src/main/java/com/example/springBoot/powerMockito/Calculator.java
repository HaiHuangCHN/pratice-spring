package com.example.springBoot.powerMockito;

public class Calculator {

    private int sum(int a, int b) {
        return a + b;
    }

    public int callSum(int a, int b) {
        return sum(a, b);
    }

}