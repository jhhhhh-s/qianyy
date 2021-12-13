package com.dingteam.demo.thread;

import lombok.SneakyThrows;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class test02 {

    public static void main(String[] args) throws  Exception {

        final int[] sum = {0};
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            int finalI1 = i;
            Future<Integer> integerFuture = executorService.submit(() -> {
                for (int j = 0; j <100 ; j++) {
                    synchronized (sum){
                        sum[0] = sum[0] + j;
                    }
                }
                System.out.println(Thread.currentThread().getName() +" : "+sum[0]);
                return  sum[0];
            });
            System.out.println("integerFuture.get() = " + integerFuture.get());
        }
        executorService.shutdown();
    }
}
