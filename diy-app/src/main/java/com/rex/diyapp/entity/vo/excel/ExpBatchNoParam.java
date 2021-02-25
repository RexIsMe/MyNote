package com.rex.diyapp.entity.vo.excel;

import java.util.HashMap;
import java.util.Map;

/**
 * 智能锁列表导出excel格式设置
 * @author zhiqiang li
 * @since 2020/7/6
 */
public class ExpBatchNoParam {

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
        columnWidthMap.put(4, 25 * 256);
        columnWidthMap.put(5, 25 * 256);
        columnWidthMap.put(6, 25 * 256);
        columnWidthMap.put(7, 25 * 256);
        columnWidthMap.put(8, 25 * 256);
        columnWidthMap.put(9, 25 * 256);
        columnWidthMap.put(10, 25 * 256);
        return columnWidthMap;
    }

}
