package com.example.redisTest.singleton;

//  饿汉模式的单例 线程安全
public class Singleton {

    private static Singleton ourInstance = new Singleton();

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
    }

//    47985092
//    47985092
//    47985092
//    47985092
//    47985092
}
