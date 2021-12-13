package com.dingteam.demo.cas;

import lombok.SneakyThrows;

import java.util.concurrent.atomic.AtomicInteger;

public class demo {



    public static void main(String[] args) {
         AtomicInteger atomicInteger1 = new AtomicInteger(0);
        for (int i = 0; i < 4; i++) {
            System.out.println(atomicInteger1.incrementAndGet());
        }

        System.out.println("atomicInteger.getAndDecrement() = " + atomicInteger1.getAndDecrement());
        System.out.println("atomicInteger.get() = " + atomicInteger1.get());



        final int[] index = {0};
        AtomicInteger atomicInteger = new AtomicInteger(0);

        for (int i = 0; i < 4; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {

                    // atomicInteger.compareAndSet方法没有自旋，需要手动实现
                    while (true){
                        if( atomicInteger.compareAndSet(0,1)) {
                            break;
                        }
                    }

                    for (int i1 = 0; i1 < 10; i1++) {
                        index[0]++;
                    }
                    System.out.println(Thread.currentThread().getName()+" -index " + index[0]);
                    atomicInteger.compareAndSet(1,0);

                }
            }).start();

        }

    }
}
