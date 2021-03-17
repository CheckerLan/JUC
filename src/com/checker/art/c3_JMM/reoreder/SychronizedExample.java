package com.checker.art.c3_JMM.reoreder;

public class SychronizedExample {
    int a = 0;
    boolean flag = false;

    // 通过synchronized进行同步
    public synchronized void write() {
        a = 1;
        flag = true;
    }

    // 通过synchronized进行同步
    public synchronized void reader() {
        if (flag) {
            int i = a * a;
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        SychronizedExample reorderExample = new SychronizedExample();
        // 执行写
        new Thread(
                () -> {
                    reorderExample.write();
                }
        ).start();

        // 执行读
        new Thread(
                () -> {
                    reorderExample.reader();
                }
        ).start();

        // synchronized进行同步后将不会进行重排序
    }
}
