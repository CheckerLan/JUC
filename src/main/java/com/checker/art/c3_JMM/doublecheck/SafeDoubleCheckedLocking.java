package com.checker.art.c3_JMM.doublecheck;

public class SafeDoubleCheckedLocking {
    private volatile static Instance instance;

    public static Instance getInstance() {

        if (instance == null) {
            synchronized (DoubleCheckedLocking.class) {
                if (instance == null) {
                    instance = new Instance();// instance为volatile,保证了读之前先写
                }
            }
        }
        return instance;
    }
}
