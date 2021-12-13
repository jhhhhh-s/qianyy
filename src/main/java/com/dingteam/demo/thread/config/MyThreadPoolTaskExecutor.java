package com.dingteam.demo.thread.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
public class MyThreadPoolTaskExecutor extends ThreadPoolTaskExecutor {

    private void logThreadPoolInfo(String prefix){
        ThreadPoolExecutor threadPoolExecutor = getThreadPoolExecutor();
        if(null == threadPoolExecutor){
            return;
        }

        log.info("{}{},taskCount [{}], completedTaskCount [{}], activeCount [{}], queueSize [{}]",
                this.getThreadNamePrefix(),
                prefix,
                threadPoolExecutor.getTaskCount(),
                threadPoolExecutor.getCompletedTaskCount(),
                threadPoolExecutor.getActiveCount(),
                threadPoolExecutor.getQueue().size());
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        logThreadPoolInfo("线程池日志");
        return super.submit(task);
    }
}
