package com.example.redisTest.singleton;

// 懒汉式单例  需要时创建
public class Singleton1 {

    private static Singleton1 singleton1;

    private Singleton1(){}

    //传统的懒汉 单例  至于为啥不线程安全 原因在于多个线程同时进入 if (singleton2 == null) {…} 语句块的情形发生。当这种这种情形发生后，该单例类就会创建出多个实例，违背单例模式的初衷。因此，传统的懒汉式单例是非线程安全的。
    public static  Singleton1 getSingleton1(){
        if (singleton1 == null){
            singleton1 =new Singleton1();
        }
        return singleton1;
    }
// 这边其实hash值应该是不完全相同的 测试数量较少
//    1145103587
//    1145103587
//    1145103587
//    1145103587
//    1145103587
}
