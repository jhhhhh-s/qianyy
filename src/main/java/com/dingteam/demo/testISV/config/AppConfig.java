package com.dingteam.demo.testISV.config;


import com.dingteam.demo.service.SynDemoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author qyy
 */

@Configuration
@ComponentScan(basePackages = "com.dingteam.demo.service")
public class AppConfig {


    SynDemoService service;

    public AppConfig(SynDemoService service) {
        this.service = service;
        System.out.println("service = " + this.service);
    }


    @Bean
    public void myBeam(){
    }


}
