package com.dingteam.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.request.OapiMessageSendToConversationRequest;
import com.dingtalk.api.request.OapiUserGetuserinfoRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiMessageSendToConversationResponse;
import com.dingtalk.api.response.OapiUserGetuserinfoResponse;
import com.dingteam.demo.service.SynDemoService;
import com.taobao.api.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/testapi")
public class SynDemoController {


    @Autowired
    SynDemoService synDemoService;


    @GetMapping("/testThreadPool")
    public  String testThreadPool() throws InterruptedException {
        if(1==1){
            synDemoService.testThreadPool();

        }
        return "success!";
    }


    @GetMapping("/testAOP")
    public  void testAop(@RequestParam(value = "name") String name){

//        System.out.println("\"testAop is successful\" = " + "testAop is successful");
    }





    @GetMapping(value = "/login")
    public Map<String ,String> login(@RequestParam("code") String authCode) throws ApiException {

//        1.获得access_token
        DingTalkClient client1 = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
        OapiGettokenRequest req = new OapiGettokenRequest();
        req.setHttpMethod("GET");
        req.setAppkey("ding14tpiionw5zja92v");
        req.setAppsecret("dgcD5xHFq-3b8fRtH0sQgdZ34qbDW-vtHh0rxLd1De70mdjBpy4HE7TjockbprJ1");
        OapiGettokenResponse rsp = client1.execute(req);
        System.out.println(rsp.getBody());
        String access_token= JSONObject.parseObject(rsp.getBody()).getString("access_token");


        // 获取用户信息
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/getuserinfo");
        OapiUserGetuserinfoRequest request = new OapiUserGetuserinfoRequest();
        request.setCode(authCode);
        request.setHttpMethod("GET");

        OapiUserGetuserinfoResponse response;
        try {
            response = client.execute(request, access_token);
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
        //2.获得userid
        String userId = response.getUserid();
        Map<String ,String> result = new HashMap<>();
        result.put("access_tockern",access_token);
        result.put("sender",userId);

        return result;
    }

    @GetMapping(value = "/sendMsg")
    public  JSONObject  sendMsg(@RequestParam("access_token")String access_token,@RequestParam("sender")String sender,@RequestParam("cid") String cid) throws ApiException {

        //发送普通消息
        DingTalkClient client  = new DefaultDingTalkClient("https://oapi.dingtalk.com/message/send_to_conversation");

        //构造请求的正文数据结构
        OapiMessageSendToConversationRequest req = new OapiMessageSendToConversationRequest();
        req.setSender(sender);
        req.setCid(cid);
        OapiMessageSendToConversationRequest.Msg msg = new OapiMessageSendToConversationRequest.Msg();

        //发送文本信息
        OapiMessageSendToConversationRequest.Text text = new OapiMessageSendToConversationRequest.Text();
        text.setContent("发送文本测试信息");
        msg.setText(text);
        msg.setMsgtype("text");
        req.setMsg(msg);

        //接收返回结果
        OapiMessageSendToConversationResponse response = client.execute(req, access_token);
        System.out.println(response.getBody());
        return JSONObject.parseObject(response.getBody());

    }

}
