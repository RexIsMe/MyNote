package com.rex.diyapp.util;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiUserGetRequest;
import com.dingtalk.api.response.OapiUserGetResponse;
import com.taobao.api.ApiException;
import lombok.extern.slf4j.Slf4j;

/**
 * 钉钉相关工具类
 *
 * @Author li zhiqang
 * @create 2020/12/16
 */
@Slf4j
public class DingDingUtils {
    private DingDingUtils() {
    }

    private static final String ACCESS_TOKEN = "36901aed58f15ee14001de2af5cdbf59fc45e5e6973203f6d6732dfce62781b5";

    /**
     *
     * @param content
     */
//    public static void sendToDingTalk(String content){
//        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/get");
//        OapiUserGetRequest req = new OapiUserGetRequest();
//        req.setUserid("userid1");
//        req.setHttpMethod("GET");
//        req.set
//        try {
//            OapiUserGetResponse rsp = client.execute(req, ACCESS_TOKEN);
//            log.info(rsp.toString());
//        } catch (ApiException e) {
//            log.error("发送到钉钉失败", e.getErrMsg());
//        }
//    }

}
