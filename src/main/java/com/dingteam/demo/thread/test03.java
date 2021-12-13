package com.dingteam.demo.thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class test03 {

    public static void main(String[] args) {


//        ExecutorService executorService1 = Executors.newCachedThreadPool();
//        for (int i = 0; i <5 ; i++) {
//            executorService1.execute(()-> System.out.println(Thread.currentThread().getName()));
//        }
//        executorService1.shutdown();
//        System.out.println("---------------");
//
//        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
//        for (int i = 0; i <5 ; i++) {
//            executorService2.execute(()-> System.out.println(Thread.currentThread().getName()));
//        }
//        executorService2.shutdown();

        System.out.println("---------------");
        ExecutorService executorService3 = Executors.newFixedThreadPool(3);
        for (int i = 0; i <5 ; i++) {
            executorService3.execute(()-> System.out.println(Thread.currentThread().getName()));
        }
        executorService3.shutdown();

        if (1==1) {
            return;
        }

        final int[] index = {0};
        Lock lock = new ReentrantLock(); //可重入锁
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i <2 ; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        try {
                            lock.lock();
                            System.out.println(Thread.currentThread().getName()+"     = " + (++index[0]));
                        } finally {
                            lock.unlock();
                        }

                    }
                }
            });
        }
        executorService.shutdown();
    }
}
