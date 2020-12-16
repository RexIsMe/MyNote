package com.rex.diyapp.controller;

import com.alibaba.fastjson.JSONObject;
import com.rex.diyapp.service.CommonService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 会员管理Controller
 *
 * @author yuanchen.zhou
 * @since 2018年05月20日
 */
@RestController
@Log4j2
@RequestMapping("common")
public class CommonController {

    @Autowired
    CommonService commonService;

    /**
     * 会员列表查询
     *
     * @return
     */
    @PostMapping(value = "/postReceiver")
    public JSONObject commonPostReceiver(@RequestBody String str) throws Exception {
        return commonService.formatAlertMsg(str);
    }



}
