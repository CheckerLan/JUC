package com.checker.art.c3_JMM.reoreder;

public class ReorderExample {
    int a = 0;
    boolean flag = false;

    public void write() {
        a = 1;
        flag = true;
    }

    public void read() {
        if (flag) {
            int i = a * a;
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            ReorderExample reorderExample = new ReorderExample();
            // 执行写
            new Thread(
                    () -> {
                        reorderExample.write();
                    }
            ).start();

            // 执行读
            new Thread(
                    () -> {
                        reorderExample.read();
                    }
            ).start();

        }


        // 在程序重排序的情况下会出现不同结果
    }
}
