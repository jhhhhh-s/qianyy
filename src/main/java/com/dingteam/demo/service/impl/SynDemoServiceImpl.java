package com.dingteam.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dingteam.demo.service.SynDemoService;
import com.google.common.collect.Maps;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
@Data
@Async("dingTalkHttpCallBackTaskExecutor")
public class SynDemoServiceImpl implements SynDemoService {

    private  String name;

    @SneakyThrows
    @Override
    public String testThreadPool()  {
//        testThreadPool1();
//        Thread.sleep(3000);
        System.out.println("\"执行业务\" = " + "执行业务1");
        return  "su";
    }

    @SneakyThrows
    public void testThreadPool1()  {

        Thread.sleep(10000);
        System.out.println("\"执行业务\" = " + "执行业务");
    }

//    public static void main(String[] args) {
//
//        Map<String ,String> map = new HashMap<>();
//        map.put(null,null);
//        System.out.println(map.get(null));
//    }
}
