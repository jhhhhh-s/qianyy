package com.dingteam.demo.thread.synzied;

import lombok.SneakyThrows;

import static java.lang.Thread.currentThread;

public class MyJoin implements Runnable {

    private  Object object = new Object();


    @SneakyThrows
    @Override
    public void run() {
        //synchronized获取当前线程的对象锁，会影响t.join()的执行
        //线程结束时，会调用线程自身的notifyAll()方法，而join底层使用wait()实现的
        synchronized (currentThread()) {
            for (int i = 1; i <= 5; i++) {
                try {
                    Thread.sleep(1000);//睡眠5秒，循环是为了方便输出信息
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("睡眠" + i);
            }
            System.out.println("TestJoin finished");//t线程结束
        }
    }


    public static void main(String[] sure) throws InterruptedException {



        Thread t = new Thread(new MyJoin());
        long start = System.currentTimeMillis();
        t.start();
        t.join(500);//等待线程t 500毫秒 ,
        // 原本t.join()方法只会使主线程进入等待池并等待500毫秒被唤醒。并不影响同一时刻处在运行状态的其他线程
        //但是 synchronized (currentThread())，主线程500毫秒后无法被唤醒
        System.out.println(System.currentTimeMillis() - start);//打印出时间间隔
        System.out.println("Main finished");//打印主线程结束
    }


}
