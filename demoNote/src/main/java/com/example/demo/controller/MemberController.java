package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;



/**
 * 会员管理Controller
 *
 * @author yuanchen.zhou
 * @since 2018年05月20日
 */
@RestController
@Log4j2
@RequestMapping("member")
public class MemberController {

    /**
     * 会员列表查询
     *
     * @return
     */
    @PostMapping(value = "/commonPostReceiver")
    public JSONObject commonPostReceiver(@RequestBody String str) throws Exception {
        System.out.println(str);


        JSONObject json = new JSONObject();
        json.put("content","success");
        json.put("msg","成功");
        json.put("status", 10000);
        return json;
    }



}
