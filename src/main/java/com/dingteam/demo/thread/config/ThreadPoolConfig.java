package com.dingteam.demo.thread.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@EnableAsync
@Configuration
public class ThreadPoolConfig {


	@Bean("dingTalkHttpCallBackTaskExecutor")
	public TaskExecutor dingTalkHttpCallBackTaskExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new MyThreadPoolTaskExecutor();
		taskExecutor.setThreadNamePrefix("dingTalkHttpCallBackTaskExecutor-");
		taskExecutor.setCorePoolSize(3);
		taskExecutor.setMaxPoolSize(10);
		taskExecutor.setQueueCapacity(3);
//		taskExecutor.initialize();
		return taskExecutor;
	}
}