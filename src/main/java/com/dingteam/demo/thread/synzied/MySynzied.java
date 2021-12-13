package com.dingteam.demo.thread.synzied;


import lombok.SneakyThrows;

public class MySynzied {

    private Object object = new Object();

    public void testSynchronzied() {

        final int[] index = {0};
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        synchronized (index) {
                            index[0]++;
                            System.out.println(Thread.currentThread().getName() + " : " + index[0]);
                        }
                    }
                }
            }).start();
        }
    }

    public void testWait() throws InterruptedException {

        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                synchronized (object) {
                    System.out.println(">>>>>>>>1");
                    object.wait();
                    System.out.println(">>>>>>>>2");
                }
            }
        }).start();

    }


    public void testNotify() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    System.out.println(">>>>>3");
                    object.notify();
                    System.out.println(">>>>>4");
                }
            }
        }).start();
    }


    public static void main(String[] args) throws InterruptedException {

        MySynzied mySynzied = new MySynzied();

        //测试线程同步
        mySynzied.testSynchronzied();

        //测试线程间通讯
//        mySynzied.testWait();
//
//        Thread.sleep(3000);
//        mySynzied.testNotify();
    }
}
