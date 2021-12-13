package com.dingteam.demo.task;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;

import java.util.Map;

@Configuration
public class SendTaskConfig {

    @Bean
    public SenderTask senderTaskRunner(Map<String,String> messageSenders) {

        return new SenderTask(messageSenders);
    }
}
