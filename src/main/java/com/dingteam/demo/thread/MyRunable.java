package com.dingteam.demo.thread;

public class MyRunable implements  Runnable {
    @Override
    public void run() {
        System.out.println("MyRunable子线程 = " + Thread.currentThread().getName());
    }
}
