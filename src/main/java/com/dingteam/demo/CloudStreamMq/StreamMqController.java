package com.dingteam.demo.CloudStreamMq;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamMqController {

    @Autowired
    StreamClient streamClient;

    /**
     * 消费消息
     *
     * @param user
     */
    @StreamListener(target = StreamClient.INPUT,condition = "headers['test']=='test'")
    public void receive(User user) {
        String s = null;
        s.toString();

        log.info("StreamReceiver: {}", user.toString());
    }


    /**
     *
     * @param user
     * @param header
     */
//    @StreamListener(target = StreamClient.INPUT)
//    public void receives(@Payload User user, @Header(name = "test") String header) {
//        log.info("StreamReceiver: {}", user.toString());
//    }



    /**
     * 生产消息
     *
     */

    @GetMapping("/sendMessage")
    public  void sendMessage(){

        User user = new User("1","1");

        streamClient.output().send(MessageBuilder.withPayload(user).setHeader("test","test").build());

      }
}
