package com.dingteam.demo.thread;


import java.util.concurrent.*;

public class test01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("主线程 = " + Thread.currentThread().getName());


        //第一种创建线程的方式
        MyThread myThread = new MyThread();
        myThread.start();

        //第二种创建线程的方式
        new Thread(new MyRunable()).start();

        //第三种创建线程的方式
        FutureTask<Integer> integerFutureTask = new FutureTask<>(() -> 1);
        new Thread(integerFutureTask).start();
        int res = integerFutureTask.get();

        System.out.println("res = " + res);


        //第四种创建线程的方式
        ExecutorService executorService = Executors.newCachedThreadPool();
        FutureTask<Integer>  futureTask = (FutureTask<Integer>) executorService.submit(() -> {
            System.out.println("线程池线程= " + Thread.currentThread().getName());
            return 1;
        });
        System.out.println("futureTask.get() = " + futureTask.get());
        executorService.shutdown();




    }
}
