package com.dingteam.demo.threadPool;


import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 线程池核心点：复用机制 ------
 * 1.提前创建好固定的线程一直在运行状态----死循环实现
 * 2.提交的线程任务缓存到一个并发队列集合中，交给我们正在运行的线程执行
 * 3.正在运行的线程就从队列中获取该任务执行
 */
public class MyThreadPool {

    //队列用来缓存提交的任务
    private LinkedBlockingDeque<Runnable>  blockingDeque ;

    public Boolean flag = true;

    /**
     * @param maxThreadCount  线程池初始运行线程数
     * @param dequeSize 队列中任务数
     */
    MyThreadPool(int maxThreadCount,int dequeSize){
        blockingDeque =   new LinkedBlockingDeque<>(dequeSize);

        for(int i=0;i<maxThreadCount;i++){
            new MyThread().start();
        }
    }


    /**
     * 提交任务
     * @param runnable
     * @return
     */
    public  Boolean excute(Runnable runnable)  {
        return  blockingDeque.offer(runnable);
    }


    class MyThread extends  Thread{
        @Override
        public void run() {
           while ( flag || blockingDeque.size()>0){

               Runnable runnable =  blockingDeque.poll();
               if(runnable!=null) {
                   runnable.run();
               }
           }
        }
    }


    public static void main(String[] args)  {

        MyThreadPool myThreadPool = new MyThreadPool(5,10);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            myThreadPool.excute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() +" : "+ finalI);
                }
            });
        }
        myThreadPool.flag = false;


    }
}
