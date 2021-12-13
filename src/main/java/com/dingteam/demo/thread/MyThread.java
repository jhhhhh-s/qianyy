package com.dingteam.demo.thread;

public class MyThread  extends  Thread{

    @Override
    public void run() {
        System.out.println("Mythrean子线程 = " + Thread.currentThread().getName());
    }
}


