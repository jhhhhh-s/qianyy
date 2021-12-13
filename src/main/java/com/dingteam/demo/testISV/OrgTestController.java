package com.dingteam.demo.testISV;


import com.dingteam.apps.framework.utils.IdGen;
import com.dingteam.apps.message.api.TodoTaskApiClient;
import com.dingteam.apps.message.model.TodoTaskSpecialParam;
import com.dingteam.apps.message.request.UpdateTodoTaskRequest;
import com.dingteam.apps.message.response.TodoTaskDetailResponse;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 纯测试用
 *
 * @author qyy
 */

@RestController
@Slf4j
@RequestMapping({"/isv"})
public class OrgTestController {

    @Autowired
    private TodoTaskApiClient todoTaskApiClient;


    @GetMapping("/senTodo")
    public List<TodoTaskDetailResponse> senTodoTask() {

        //使用消息模板
        String corpId = "dinged4828346906753435c2f4657eb6378f";

        //参数信息
        Map<String, String> parHashMap = new HashMap<>();
        parHashMap.put("subject", "哈利波特骑着扫帚飞");
        parHashMap.put("dueTime", String.valueOf(System.currentTimeMillis()));
        parHashMap.put("appUrl", "http://www.baidu.com");
        parHashMap.put("pcUrl", "http://www.baidu.com");
        parHashMap.put("isOnlyShowExecutor", "true");
        parHashMap.put("priority", "10");


        String bizId = IdGen.next();
        UpdateTodoTaskRequest todoTaskRequest = new UpdateTodoTaskRequest();
        todoTaskRequest.setTemplateKey("signature.task2");
        todoTaskRequest.setBizId(bizId);
        todoTaskRequest.setCorpId(corpId);
        todoTaskRequest.setOperatorId("9qmkyZiix8CbDYiSvTajV3dAiEiE");
        todoTaskRequest.setVars(parHashMap);
        todoTaskRequest.setOptions(null);

        TodoTaskSpecialParam param = new TodoTaskSpecialParam();
        param.setExecutorIds(Lists.newArrayList("9qmkyZiix8CbDYiSvTajV3dAiEiE"));
        todoTaskRequest.setSpecialParams(param);


        String taskId = todoTaskApiClient.createOrUpdate("1fmfa8hhtd57w1f0w2mg79uc3efkbv8o", todoTaskRequest);
        log.info("发送成功,bizId:{},corpId:{},taskId:{}", bizId, corpId, taskId);

        //List<TodoTaskDetailResponse> responses = todoTaskApiClient.getDetail(corpId,taskId);
        //log.info("responses:{}",JSON.toJSONString(responses));

        //todoTaskApiClient.delete(corpId,taskId, "9qmkyZiix8CbDYiSvTajV3dAiEiE");
        return null;
    }

}
