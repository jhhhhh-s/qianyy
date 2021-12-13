package com.dingteam.demo.hashMap;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;

public class test {


    public static void main(String[] args) {


        MyHashMap<Object ,Object> myHashMap = new MyHashMap<Object ,Object>();

          for(int i=0;i<18;i++){
              myHashMap.put(i,i);
          }
        myHashMap.put("a","aaaaa");
//        myHashMap.put(97,"979779797");
//        myHashMap.put(null,null);
//        System.out.println(myHashMap.get("a"));
//        System.out.println(myHashMap.get(97));
//        System.out.println(myHashMap.get(null));

    }
}
