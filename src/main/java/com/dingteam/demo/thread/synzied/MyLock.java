package com.dingteam.demo.thread.synzied;

import lombok.SneakyThrows;

import java.sql.SQLOutput;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyLock {

    private Lock lock = new ReentrantLock();
    private  ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private  Lock readLock =reentrantReadWriteLock.readLock();//定义读锁
    private  Lock writeLock = reentrantReadWriteLock.writeLock();//定义写锁




    public void test1() throws InterruptedException {

        lock.lock();
        try {
            System.out.println("调用test1()方法"+Thread.currentThread().getName());
            test2();
            Thread.sleep(3000);
        } finally {
            lock.unlock();
        }
        System.out.println("chile thread is oever!");

    }


    private  void test2(){
        lock.lock();
        System.out.println("调用test2()方法: "+Thread.currentThread().getName());
        lock.unlock();
    }


    public static void main(String[] args) {

        //验证可重入锁
        MyLock myLock = new MyLock();
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                myLock.test1();
            }
        }).start();

        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                myLock.test2();
            }
        }).start();

    }


}
