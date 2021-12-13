package com.dingteam.demo.task;


import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.task.TaskExecutor;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * 子任务处理，生成数据存入队列
 */
@AllArgsConstructor
public class SenderTask implements CommandLineRunner {

    private final Map<String,String> messageSenders;
//
//    private final TaskExecutor taskExecutor;


    @Override
    public void run(String... args) throws Exception {
        this.messageSenders.forEach((senderName, sender) -> {
            CompletableFuture.runAsync(() -> {

                System.out.printf("---------------------");
            });
        });
    }
}
