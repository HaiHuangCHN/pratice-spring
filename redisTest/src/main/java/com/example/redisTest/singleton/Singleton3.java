package com.example.redisTest.singleton;

// 懒汉式单例  需要时创建
public class Singleton3 {

    private static Singleton3 singleton3;

    private Singleton3(){}

    //同步延迟加载 — synchronized块
    public static  Singleton3 getSingleton3(){
        synchronized(Singleton3.class){
        if (singleton3 == null){
            singleton3 =new Singleton3();
        }
        return singleton3;
    }
    }
//
//    905890999
//            905890999
//            905890999
//            905890999
//            905890999

}
