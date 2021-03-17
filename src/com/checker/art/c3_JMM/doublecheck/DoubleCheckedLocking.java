package com.checker.art.c3_JMM.doublecheck;

public class DoubleCheckedLocking {
    private static Instance instance;

    public static Instance getInstance() {
        // 问题同样为等于空时可能已经在初始化，但未初始化完成
        if (instance == null) {
            synchronized (DoubleCheckedLocking.class) {
                if (instance == null) {
                    instance = new Instance();
                    /**
                     * 可以分解为
                     *
                     * memory = allocate();     // 分配对象的内存空间
                     * ctorInstance(memory);    // 初始化对象
                     * instance = memory;       // 设置instance指向刚分配的内存地址
                     *
                     * 其中第二步和第三步在某些编译器上可能重排序
                     */
                }
            }
        }
        return instance;
    }

}
