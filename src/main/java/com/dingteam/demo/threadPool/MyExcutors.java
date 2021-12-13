package com.dingteam.demo.threadPool;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

public class MyExcutors {


    public static void main(String[] args) {

        /**
         * AbortPolicy 默认策略，丢掉任务并且抛出异常
         * DiscardPolicy 丢掉任务但是不抛出异常
         * DiscardOldestPolicy 丢弃队列中的第一个任务，加入这个任务
         * CallerRunsPolicy   不会丢弃任务，子线程不执行，由主线程自己去执行
         * MyRejectedExecutionHandler 自定义的执行策略
         */

        ExecutorService  executorService = new ThreadPoolExecutor(2, 4,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(4),
                new MyRejectedExecutionHandler());

        for (int i = 0; i < 9; i++) {
            int finalI = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+" : "+ finalI);
                }
            });
        }
        executorService.shutdown();

    }
}
