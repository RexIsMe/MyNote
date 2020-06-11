package com.example.demo.utils.excel.expoermodel1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rex
 * @title: ExcelFormat
 * @projectName demoNote
 * @description: TODO
 * @date 2020/5/816:36
 */
public class ExcelFormat1 {

    /**
     * (示例)
     * 初始化csv 列宽
     *
     * @return
     */
    public static Map<Integer, Integer> initColumnWidth() {
        Map<Integer, Integer> columnWidthMap = new HashMap<>();
        columnWidthMap.put(0, 25 * 256);
        columnWidthMap.put(1, 25 * 256);
        columnWidthMap.put(2, 25 * 256);
        columnWidthMap.put(3, 25 * 256);
        columnWidthMap.put(4, 15 * 256);
        columnWidthMap.put(5, 15 * 256);
        columnWidthMap.put(6, 15 * 256);
        columnWidthMap.put(7, 15 * 256);
        columnWidthMap.put(8, 35 * 256);
        columnWidthMap.put(9, 25 * 256);
        columnWidthMap.put(10, 250 * 256);
        return columnWidthMap;
    }
}
