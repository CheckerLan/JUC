package com.checker.art.c3_JMM.doublecheck;

public class InstanceFactory {
    private static class InstanceHoler{
        public static Instance instance = new Instance();
    }

    public static Instance getInstance(){
        return InstanceHoler.instance;
        // 类初始化时Instance也初始化
    }
}
