package com.checker.art.c3_JMM.volatileExample;

public class VolatileFeaturesExample {
    volatile long vl = 0L;

    public void set(long l) {
        vl = l;
        // 此时volatile与synchronized效果相同
    }

    public long get() {
        return vl;
        // 此时volatile与synchronized效果相同
    }

    public void getAndIncrement() {
        vl++;
        // 复合volatile的读写
        /**
         * 等价于
         *
         * long temp = get();
         * temp += 1L;
         * set(temp);
         */
    }


}
