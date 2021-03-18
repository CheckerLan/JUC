package com.checker.art.c4_Basic;

public class Synchronized {
    public static void main(String[] args) {
        synchronized (Synchronized.class) {
        }
        // 静态同步方法，对Synchronized Class对象进行加锁
        m();
    }

    public static synchronized void m() {
    }
}
