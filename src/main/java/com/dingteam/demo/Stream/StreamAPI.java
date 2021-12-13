package com.dingteam.demo.Stream;

import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class StreamAPI {

    private static String s1;
    private  String s2;

    /**
     * 1.静态内部类可以跳过外部类直接创建
     * 2.只能访问外部类的静态成员
     */
    @Data
    @Builder(toBuilder = true)   ///true属性获取实例初始化的生成器，生成toBuilder()方法
    private static  class StaticInnerClass{

        private  String userId;
        private  String name;

        private  void U1(){
            StreamAPI.s1 = StringUtils.EMPTY; //使用外部类的静态属性
            return;
        }
        private static void U2(){ return;}
    }

    /**
     * 1.普通的内部类必须先创建外部类才能创建内部类
     * 2.可以访问外部类的所有成员
     */
    @Data
    private class  InnerClass{

        private  String d1;

        private void inner(){
            StreamAPI.this.s2 = StringUtils.EMPTY; //使用外部类的非静态属性
            return;
        }

    }

    /**
     * 内部类的接口用于生成匿名内部类
     */
    private  interface  HelloWord{

        public static final String HELLO = StringUtils.EMPTY;  //公共静态不可修改常量，必须初始化
         void sayHello();
    }


    public static void main(String[] args) {

        //静态内部类直接创建
        StaticInnerClass staticInnerClass = StreamAPI.StaticInnerClass.builder()
                .userId("1")
                .name("jack")
                .build();
        staticInnerClass = staticInnerClass.toBuilder()
                .userId("2")
                .name("tom")
                .build();

        StaticInnerClass.U2(); // 静态方法通过类直接调用
        staticInnerClass.U1(); // 非静态方法通过实例对象调用
        System.out.println(staticInnerClass);

        //内部类必须先创建外部类
        StreamAPI.InnerClass innerClass = new StreamAPI().new InnerClass();

        //使用匿名内部类实现HelloWord接口
        HelloWord helloWord = new StreamAPI.HelloWord(){
            @Override
            public void sayHello(){
                System.out.println("hello world!");
                return;
            }
        };
        helloWord.sayHello();

    }
}
