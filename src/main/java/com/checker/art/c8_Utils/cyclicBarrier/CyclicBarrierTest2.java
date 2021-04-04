package com.checker.art.c8_Utils.cyclicBarrier;

import java.util.TreeMap;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    // 总共有2个业务
    static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) {
        new Thread(
                // Runnable.run
                () -> {
                    try {
                        System.out.println("业务1等待其他业务到位");
                        c.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println("业务1");
                }
        ).start();

        new Thread(
                // Runnable.run
                () -> {
                    try {
                        System.out.println("业务2等待其他业务到位");
                        c.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println("业务2");
                }
        ).start();
    }
}
