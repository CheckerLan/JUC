package com.checker.art.c4_Basic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Priority {
    private static volatile boolean notStart = true;
    private static volatile boolean notEnd = true;

    public static void main(String[] args) throws InterruptedException {
        List<Job> jobs = new ArrayList<Job>();
        for (int i = 0; i < 10; i++) {
            // 小于5则取最小值，否则取最大
            int priortity = i < 5 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
            Job job = new Job(priortity);
            jobs.add(job);
            Thread thread = new Thread(job, "Thread" + i);
            thread.setPriority(priortity);
            thread.start();
        }
        notStart = false;
        TimeUnit.SECONDS.sleep(10);
        notEnd = false;

        for (Job job : jobs) {
            System.out.println("Job priority : " + job.priority + ", count : " + job.jobCount);
        }
    }

    static class Job implements Runnable {
        private int priority;
        private long jobCount;

        public Job(int priority) {
            this.priority = priority;
        }

        @Override
        public void run() {
            while (notStart) {
                // 礼让,令cpu重新调度
                Thread.yield();
            }
            while (notEnd) {
                // 礼让，令cpu重新调度
                Thread.yield();
                jobCount++;
            }

        }
    }
}
