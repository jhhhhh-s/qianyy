package com.dingteam.demo;

import com.dingteam.apps.message.api.MessageApiClient;
import com.dingteam.apps.message.api.TodoTaskApiClient;
import com.dingteam.org.api.OrgApiClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @author qyy
 */
@SpringBootApplication
@EnableFeignClients(clients = {
        OrgApiClient.class,
        MessageApiClient.class,
        TodoTaskApiClient.class})
public class DingTeamDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DingTeamDemoApplication.class, args);
    }
}
