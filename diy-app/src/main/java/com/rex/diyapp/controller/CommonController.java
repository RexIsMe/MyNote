package com.rex.diyapp.controller;

import com.alibaba.fastjson.JSONObject;
import com.rex.diyapp.service.CommonService;
import com.thalys.dcframework.entity.DCRecordEntity;
import com.thalys.dcframework.util.DCFileSystemUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


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


    /**
     * 会员列表查询
     *
     * @return
     */
    @RequestMapping(value = "/testOSS", method = RequestMethod.GET)
    public JSONObject testOSS() throws Exception {

        try{
            DCFileSystemUtils.writeToFileSystem(getDCRecordEntity());
        } catch (Exception e){
            log.error("", e);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "成功");
        jsonObject.put("content", "success");
        jsonObject.put("status", 10000);
        return jsonObject;
    }

    private DCRecordEntity getDCRecordEntity(){

        List dataList = new ArrayList();
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("customerEnableCode","0.ZGS.NM.NMZX.0001");
        objectObjectHashMap.put("ownerId",39);
        objectObjectHashMap.put("organizationId",2);
        objectObjectHashMap.put("inventoryNumber",20);
        objectObjectHashMap.put("effectiveDays",360);
        objectObjectHashMap.put("packageUnitName","盒");
        objectObjectHashMap.put("warehouseAreaDesc","冷藏区");
        objectObjectHashMap.put("registerNumber","国械注进20172400054");
        objectObjectHashMap.put("warehouseCategoryId",2);
        objectObjectHashMap.put("commodityNumber","00001");
        objectObjectHashMap.put("supplierEnableCode","6.01.01.0008");
        objectObjectHashMap.put("logicAreaId",75);
        objectObjectHashMap.put("commodityType","2137");
        objectObjectHashMap.put("customerName","测试内蒙古医科大学附属人民医院CS1");
        objectObjectHashMap.put("warehouseId",53);
        objectObjectHashMap.put("storageCondition","2-10摄氏度");
        objectObjectHashMap.put("inventoryOrganizationCode","0120");
        objectObjectHashMap.put("producedDate",1600185600);
        objectObjectHashMap.put("warehouseAreaCode","LC");
        objectObjectHashMap.put("accountingName","");
        objectObjectHashMap.put("ownerCode","0120");
        objectObjectHashMap.put("allocatedQuantity",0);
        objectObjectHashMap.put("customerCode","0.ZGS.NM.NMZX.0001");
        objectObjectHashMap.put("supplierCode","6.01.01.0008");
        objectObjectHashMap.put("warehouseName","内蒙塞力斯总仓");
        objectObjectHashMap.put("goodsLocation","LC02-021701");
        objectObjectHashMap.put("customerId",7432);
        objectObjectHashMap.put("isSimplelevy","0");
        objectObjectHashMap.put("logicAreaName","冷藏肿瘤医院器械");
        objectObjectHashMap.put("deviceClassify","体外诊断试剂");
        objectObjectHashMap.put("coldChainMark","2153");
        objectObjectHashMap.put("classifyIdLevel1","器械类-试剂");
        objectObjectHashMap.put("classifyIdLevel2","试剂-主试剂");
        objectObjectHashMap.put("effectiveDate",1631289600);
        objectObjectHashMap.put("commodityName","维生素B12测定试剂盒（化学发光法）");
        objectObjectHashMap.put("accountingMl","");
        objectObjectHashMap.put("manufacturerName","贝克曼库尔特商贸(中国)有限公司");
        objectObjectHashMap.put("warehouseCategoryCode","QUALIFIED");
        objectObjectHashMap.put("sterilizationBatchNo","1");
        objectObjectHashMap.put("commodityCode","1.02.00001");
        objectObjectHashMap.put("batchNo","1");
        objectObjectHashMap.put("brandName","贝克曼");
        objectObjectHashMap.put("commoditySpec","2*50个测试/盒");
        objectObjectHashMap.put("organizationName","塞力斯医疗科技股份有限公司");
        objectObjectHashMap.put("productionPlace","国产");
        objectObjectHashMap.put("professionalGroup","免疫-发光");
        objectObjectHashMap.put("quotiety",1);
        objectObjectHashMap.put("goodsLocationId",5133);
        objectObjectHashMap.put("productionLicense","");
        objectObjectHashMap.put("supplierId",5219);
        objectObjectHashMap.put("packageUnitId",2038);
        objectObjectHashMap.put("warehouseCode","012001");
        objectObjectHashMap.put("inventoryOrganizationName","内蒙古塞力斯医疗科技有限公司");
        objectObjectHashMap.put("ownerName","内蒙古塞力斯医疗科技有限公司");
        objectObjectHashMap.put("supplierName","成都瑞琦医疗科技有限责任公司");
        objectObjectHashMap.put("quantity",20);
        objectObjectHashMap.put("inventoryOrganizationId",48);
        objectObjectHashMap.put("deviceClassifyType","2035");
        objectObjectHashMap.put("warehouseCategoryName","合格");
        objectObjectHashMap.put("commodityId",53574);
        objectObjectHashMap.put("commodityRemark","");
        objectObjectHashMap.put("warehouseAreaId",94);
        objectObjectHashMap.put("logicAreaCode","LC_ZLYYQX");
        objectObjectHashMap.put("accountingOne","");
        objectObjectHashMap.put("registerName","维生素B12试剂盒");

        HashMap<Object, Object> objectObjectHashMap1 = new HashMap<>();
        objectObjectHashMap1.put("customerEnableCode", "");
        objectObjectHashMap1.put("ownerId", 1);
        objectObjectHashMap1.put("organizationId", 2);
        objectObjectHashMap1.put("inventoryNumber", 8);
        objectObjectHashMap1.put("effectiveDays", 720);
        objectObjectHashMap1.put("packageUnitName", "条");
        objectObjectHashMap1.put("warehouseAreaDesc", "冷藏");
        objectObjectHashMap1.put("registerNumber", "国械注进20162401163");
        objectObjectHashMap1.put("warehouseCategoryId", 2);
        objectObjectHashMap1.put("commodityNumber", "F000311");
        objectObjectHashMap1.put("supplierEnableCode", "3.01.01.0226.01");
        objectObjectHashMap1.put("logicAreaId", 63);
        objectObjectHashMap1.put("commodityType", "2137");
        objectObjectHashMap1.put("customerName", "");
        objectObjectHashMap1.put("warehouseId", 41);
        objectObjectHashMap1.put("storageCondition", "冷藏");
        objectObjectHashMap1.put("inventoryOrganizationCode", "0109");
        objectObjectHashMap1.put("producedDate", 1579449600);
        objectObjectHashMap1.put("warehouseAreaCode", "LC");
        objectObjectHashMap1.put("accountingName", "耗材（含各种洗液、定标质控、一次性使用耗材等）");
        objectObjectHashMap1.put("ownerCode", "0109");
        objectObjectHashMap1.put("allocatedQuantity", 0);
        objectObjectHashMap1.put("customerCode", "");
        objectObjectHashMap1.put("supplierCode", "3.01.01.0226.01");
        objectObjectHashMap1.put("warehouseName", "奥申博仓库");
        objectObjectHashMap1.put("goodsLocation", "LC1-010101");
        objectObjectHashMap1.put("isSimplelevy", "0");
        objectObjectHashMap1.put("logicAreaName", "LC-冷藏区");
        objectObjectHashMap1.put("deviceClassify", "体外诊断试剂");
        objectObjectHashMap1.put("coldChainMark", "2153");
        objectObjectHashMap1.put("classifyIdLevel1", "器械类-试剂");
        objectObjectHashMap1.put("classifyIdLevel2", "试剂-主试剂");
        objectObjectHashMap1.put("effectiveDate", 1662739200);
        objectObjectHashMap1.put("commodityName", "待用---缓冲液1");
        objectObjectHashMap1.put("accountingMl", "");
        objectObjectHashMap1.put("manufacturerName", "Siemens Healthcare Diagnostics products GmbH");
        objectObjectHashMap1.put("warehouseCategoryCode", "QUALIFIED");
        objectObjectHashMap1.put("sterilizationBatchNo", "");
        objectObjectHashMap1.put("commodityCode", "1.01.15.F00031");
        objectObjectHashMap1.put("batchNo", "081411");
        objectObjectHashMap1.put("brandName", "西门子");
        objectObjectHashMap1.put("commoditySpec", "   10*15ml");
        objectObjectHashMap1.put("organizationName", "塞力斯医疗科技股份有限公司");
        objectObjectHashMap1.put("productionPlace", "国产");
        objectObjectHashMap1.put("professionalGroup", "临检-血凝");
        objectObjectHashMap1.put("quotiety", 1);
        objectObjectHashMap1.put("goodsLocationId", 2737);
        objectObjectHashMap1.put("productionLicense", "");
        objectObjectHashMap1.put("supplierId", 5104);
        objectObjectHashMap1.put("packageUnitId", 2040);
        objectObjectHashMap1.put("warehouseCode", "010901");
        objectObjectHashMap1.put("inventoryOrganizationName", "武汉奥申博科技有限公司");
        objectObjectHashMap1.put("ownerName", "武汉奥申博科技有限公司");
        objectObjectHashMap1.put("supplierName", "武汉逸文商贸有限公司");
        objectObjectHashMap1.put("quantity", 10);
        objectObjectHashMap1.put("inventoryOrganizationId", 39);
        objectObjectHashMap1.put("deviceClassifyType", "2035");
        objectObjectHashMap1.put("warehouseCategoryName", "合格");
        objectObjectHashMap1.put("commodityId", 59743);
        objectObjectHashMap1.put("commodityRemark", "");
        objectObjectHashMap1.put("warehouseAreaId", 90);
        objectObjectHashMap1.put("logicAreaCode", "LC");
        objectObjectHashMap1.put("accountingOne", "");
        objectObjectHashMap1.put("registerName", "缓冲液");

        dataList.add(objectObjectHashMap);
        dataList.add(objectObjectHashMap1);

        DCRecordEntity dcRecordEntity = new DCRecordEntity();
        dcRecordEntity.setCompanyName("thalys.tyche");
        dcRecordEntity.setBusinessName("stock");
        dcRecordEntity.setDataList(dataList);
        return dcRecordEntity;
    }


}
