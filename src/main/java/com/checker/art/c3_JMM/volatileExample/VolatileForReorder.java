package com.checker.art.c3_JMM.volatileExample;

public class VolatileForReorder {
    static int a = 0;
    static boolean flag = false;

    static class writer extends Thread {
        @Override
        public void run() {
            a = 1;
            flag = true;
        }


    }

    static class reader extends Thread {
        @Override
        public void run() {
            if (flag) {
                int i = a;
                if (a == 0) {
                    System.out.print(i);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 50000; i++) {
            writer threadA = new writer();
            threadA.start();

            reader threadB = new reader();
            threadB.start();

            threadA.join();
            threadB.join();

            flag = false;
            a = 0;

        }

        // volatile禁止flag=true和if(flag)重排序，建立了happens-before关系
    }
}
