package com.dingteam.demo.cas;

import java.lang.annotation.Annotation;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class MyCasLock {

   private AtomicInteger atomicInteger = new AtomicInteger(0);

    private int count = 0;


    public  boolean lock(){

        //自旋可能会出现cpu飙高的问题，所以要考虑自旋的次数问题，不能陷入死循环
        while (true){
            if(atomicInteger.compareAndSet(0,1)){
                System.out.println(Thread.currentThread().getName()+" 自旋成功");
                return  true;
            }

            System.out.println(Thread.currentThread().getName()+" 自旋失败");
        }

    }

    public  boolean unlock(){

        System.out.println("count = " + count);
        return  atomicInteger.compareAndSet(1,0);
    }


    public static void main(String[] args) {

        MyCasLock myCasLock  = new MyCasLock();
        IntStream.range(0,5).forEach(i->new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    myCasLock.lock();
                    myCasLock.count++;
                } finally {
                    myCasLock.unlock();
                }

            }
        }).start()
        );

    }
}
