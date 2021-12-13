package com.dingteam.demo.MyOptional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class test1 {
    public static void main(String[] args) {

//        Object object = new Object();
//        Optional.ofNullable(object).ifPresent(new Consumer<Object>() {
//            @Override
//            public void accept(Object o) {
//                System.out.println("this is not null");
//            }
//        });


        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);

        Integer in = list.stream().filter(i -> {
            return i.equals(1);
        }).findFirst().orElse(null);
        System.out.println(in);

    }
}
