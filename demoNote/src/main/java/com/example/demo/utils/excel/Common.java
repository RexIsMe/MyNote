package com.example.demo.utils.excel;

import com.example.demo.utils.excel.expoermodel1.ExcelFormat1;
import com.example.demo.utils.excel.expoermodel1.ExpLockLogVO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Rex
 * @title: Common
 * @projectName demoNote
 * @description: TODO
 * @date 2020/5/816:35
 */
public class Common {

    public static void main(String[] args) {
        ExcelUtil.expLocalExcel(ExpLockLogVO.class, preperData(), ExcelFormat1.initColumnWidth(), "C:\\Users\\99686\\Desktop\\test.csv","");
    }

    public static List<ExpLockLogVO> preperData(){
        ExpLockLogVO expLockLogVO = new ExpLockLogVO();
        expLockLogVO.setAvgSignal(new BigDecimal(1));
        expLockLogVO.setCabinetName("qwe");
        expLockLogVO.setDepartmentName("222");
        expLockLogVO.setHospitalName("123");
        expLockLogVO.setLockName("123");
        expLockLogVO.setLostCount(1);
        expLockLogVO.setLostDetail("123123");
        expLockLogVO.setMaxSignal(new BigDecimal(2));
        expLockLogVO.setMinSignal(new BigDecimal(1));
        expLockLogVO.setMinSignalTimes("123");
        expLockLogVO.setWardName("123123");

        List<ExpLockLogVO> list = new ArrayList<>();
        list.add(expLockLogVO);
        return list;
    }


}
