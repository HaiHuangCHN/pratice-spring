package com.example.redisTest.singleton;

// 懒汉式单例  需要时创建
public class Singleton2 {

    private static  Singleton2 singleton2;

    private Singleton2(){}

    //同步延迟加载 — synchronized方法 线程安全 但是效率很低
    public static synchronized Singleton2 getSingleton2(){
        if (singleton2 == null){
            singleton2 =new Singleton2();
        }
        return singleton2;
    }
//
//    1145103587
//    1145103587
//    1145103587
//    1145103587
//    1145103587
}
