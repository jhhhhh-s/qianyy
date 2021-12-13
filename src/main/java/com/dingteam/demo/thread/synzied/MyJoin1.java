package com.dingteam.demo.thread.synzied;

import lombok.SneakyThrows;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyJoin1 implements Runnable {

    private Lock lock = new ReentrantLock();

    @SneakyThrows
    @Override
    public void run() {
        try {
            if (Thread.currentThread().isInterrupted()){
                System.out.println("线程被中断");
            }else {
                Thread.sleep(5000);
                System.out.println("child is runing!");
            }
        } catch (InterruptedException e) {
            System.out.println("子线程被中断n>>>>>");
        }


    }


    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new MyJoin1());

        thread.start();
        /*
        如果线程被Object.wait, Thread.join和Thread.sleep三种方法之一阻塞，
        此时调用该线程的interrupt()方法，
        那么该线程将抛出一个 InterruptedException中断异常。
         */
        Thread.sleep(2000);
       // thread.interrupt();

        //synchronized获得对象锁是线程的实例时，当线程结束时，会调用线程自身的notifyAll()方法
        //相当于thread.join()的作用
        synchronized (thread) {
            thread.wait();  //阻塞等到子线程执行结束
        }


        System.out.println("main is over!");
    }


}
