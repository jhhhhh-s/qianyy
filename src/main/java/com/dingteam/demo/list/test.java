package com.dingteam.demo.list;

import java.util.ArrayList;
import java.util.LinkedList;

public class test {

    public static void main(String[] args) {


        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.remove("1");



//        MyArryList<Object> arryList = new MyArryList<>();
//        for(int i=0;i<5;i++){
//            arryList.add(i);
//        }
//        arryList.remove(4);
//
//        for(int i=0;i<5;i++){
//            System.out.println("arryList.get(i) = " + arryList.get(i));
//        }


        MyLinkList myLinkList = new MyLinkList();

        myLinkList.add(1);
        myLinkList.add(2);
        myLinkList.add(3);

        myLinkList.remove(2);

        return;

    }
}
