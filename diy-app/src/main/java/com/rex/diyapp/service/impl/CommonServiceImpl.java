package com.rex.diyapp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.rex.diyapp.client.DingTalkRobotClient;
import com.rex.diyapp.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author li zhiqang
 * @create 2020/12/16
 */
@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private DingTalkRobotClient dingTalkRobotClient;

    @Override
    public JSONObject formatAlertMsg(String alertMsg) {

        dingTalkRobotClient.sendTextMessage(alertMsg, new String[]{"18272163813"});

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "成功");
        jsonObject.put("content", "success");
        jsonObject.put("status", 10000);
        return jsonObject;
    }

}
