package com.example.redisTest.singleton;

// 懒汉式单例  需要时创建
public class Singleton5 {

    private static class Hoder{
       private static Singleton5 ourInstance = new Singleton5();
    }

    public static Singleton5 getInstance5() {
        return Hoder.ourInstance;
    }

    private Singleton5() {
    }

// 这边其实hash值应该是不完全相同的 测试数量较少
//    1145103587
//    1145103587
//    1145103587
//    1145103587
//    1145103587
}
