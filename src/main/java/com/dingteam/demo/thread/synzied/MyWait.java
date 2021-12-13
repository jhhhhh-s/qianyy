package com.dingteam.demo.thread.synzied;

import lombok.Data;


public class MyWait {



    @Data
    class User{
        String name;
        String sex;
        boolean flag = false; //默认生产者主动去生产
    }

    //生产者
    class inputThread extends  Thread{
        private  User user;

        public inputThread(User u){
            this.user = u;
        }

        @Override
        public void run() {
            Integer count = 0 ;
            while (true){
                synchronized (user){

                    //如果此时生产的产品没被消费掉，则不需要生产
                    if(user.flag){
                        try {
                            user.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //生产产品
                    if(count == 0){
                        user.name = "jack";
                        user.sex = "男";
                    }
                    else{
                        user.name = "marry";
                        user.sex = "女";
                    }
                    //生产一个产品则标记一下
                    user.flag = true;
                    //唤醒消费者进行消费
                    user.notify();

                    count = (count + 1) % 2;
                }

            }
        }
    }

    //消费者
    class outputThread extends  Thread{
        private  User user;

        public outputThread(User u){
            this.user = u;
        }

        @Override
        public void run() {
            while (true){
                synchronized (user){

                    //消费者进行产品消费
                    if(!user.flag){
                        try {
                            user.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(user.getName() +" : "+user.getSex());
                    user.flag = false;
                    user.notify();
                }
            }
        }

    }

    public  void test(){
        User user = new User();
        new inputThread(user).start();
        new outputThread(user).start();
    }


    public static void main(String[] args) {

        MyWait myWait = new MyWait();
        myWait.test();

    }

}
