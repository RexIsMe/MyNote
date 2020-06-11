//package com.example.demo.module.exportamq.controller;
//
//import com.alibaba.fastjson.JSONObject;
//import com.tyche.framework.common.OsResult;
//import com.tyche.icms.dubbo.price.utils.PricePlanUtils;
//import com.tyche.icms.entity.LockSignal;
//import com.tyche.icms.module.test.service.LockSignalService;
//import com.tyche.icms.utils.DateUtil;
//import com.tyche.icms.utils.EntityBeanUtil;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 会员管理Controller
// *
// * @author yuanchen.zhou
// * @since 2018年05月20日
// */
//@RestController
//@Log4j2
//@RequestMapping("test")
//public class TestController {
//
//    @Autowired
//    PricePlanUtils pricePlanUtils;
//    @Resource
//    LockSignalService lockSignalService;
//
//    /**
//     * 导出智能锁日志信息csv方法
//     */
//    @RequestMapping(value = "/explockLog", method = RequestMethod.GET)
//    public void explockLog(String excelPath) {
//        lockSignalService.getLockLog(excelPath);
//    }
//
//    /**
//     * 读取Amq log信息
//     *
//     * @return
//     */
//    @RequestMapping(value = "/readAmqLog", method = RequestMethod.GET)
//    public OsResult readAmqLog(String txtPath) throws Exception {
//        List<LockSignal> lockSignalDTOList = readAmqLogFun(txtPath);
//        List<LockSignal> resultList = new ArrayList<>();
//        try{
//            for (int n = 0, t = lockSignalDTOList.size(); n < t; n++) {
//                resultList.add(lockSignalDTOList.get(n));
//                if (resultList.size() % 30000 == 0 || n == t - 1) {
//                    log.info("AA " + t + " N ： {},resultList.size:{}", String.valueOf(n), String.valueOf(resultList.size()));
//                    lockSignalService.insertList(resultList);
//                    resultList = new ArrayList<>();
//                }
//            }
//        } catch (Exception e) {
//            log.error(e.getMessage());
//        }
//
//        return OsResult.buildBizSuccessResult("插入成功");
//    }
//
//    /**
//     * 读取AMQ 日志记录
//     *
//     * @return
//     * @throws Exception
//     */
//    private List<LockSignal> readAmqLogFun(String txtPath) throws Exception {
//        List<LockSignal> list = new ArrayList<>();
//        FileInputStream fstream = new FileInputStream(new File(txtPath));// 0428--> 861792
//        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
//        String strLine;
//        while ((strLine = br.readLine()) != null) {
//            String parStr = strLine;
//            String tempInfoStr = "发送的消息为:";
//            JSONObject jsonObject = JSONObject.parseObject(parStr);
//            String contentStr = jsonObject.getString("content");
//            String[] startStrArray = contentStr.split(" ");
//            if (startStrArray[5].indexOf("TK.IC01") < 0) {
//                continue;
//            }
//            String[] endStrArray = startStrArray[5].split(tempInfoStr);
//            LockSignal lockSignal = new LockSignal();
//            lockSignal.setStatus(1);
//            lockSignal.setReceiveTime(startStrArray[0]);
//            lockSignal.setSendTime(DateUtil.stringtoDate(startStrArray[0], DateUtil.FORMAT_TEMP));
//            JSONObject endJsonObj = JSONObject.parseObject(endStrArray[1]);
//            lockSignal.setLockNum(endJsonObj.getString("lockNum"));
//            lockSignal.setLockStatus(Integer.parseInt(endJsonObj.getString("lockStatus")));
//            lockSignal.setSignalIntensity(Integer.parseInt(endJsonObj.getString("signal")));
//            BeanUtils.copyProperties(EntityBeanUtil.initDtoProperty(true), lockSignal);
//            list.add(lockSignal);
//        }
//        return list;
//    }
//
//}
