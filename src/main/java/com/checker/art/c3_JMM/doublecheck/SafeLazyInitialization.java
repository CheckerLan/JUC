package com.checker.art.c3_JMM.doublecheck;

public class SafeLazyInitialization {
    private static Instance instance;

    // synchronized保证多线程调用GetInstance（）的时候不会出现一个线程在初始化完成前获取到实例
    public synchronized static Instance getInstance() {
        if (instance == null) {
            instance = new Instance();
            //此处不是原子操作，多线程下会出现问题
        }
        return instance;
    }

    public static void main(String[] args) {
        Instance theInstance = SafeLazyInitialization.getInstance();
    }
}

class Instance {

}