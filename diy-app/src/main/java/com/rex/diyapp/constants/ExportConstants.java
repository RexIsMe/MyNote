package com.rex.diyapp.constants;

/**
 * “导出”相关常量
 *
 * @author zhiqiang li
 * @since 2020/7/2
 */
public class ExportConstants {
    private ExportConstants() {
    }

    //批号货位库存表导出excel - OSS文件夹
    public static final String OSS_BATCH_NO_PATH = "DC/ERP/getBatchNo";
    //批号货位库存表导出redisKey前缀标识
    public static final String REDIS_KEY_PREFIX_OF_BATCH_NO_LIST = "DC:ERP:exp_batch_no_list_";
    //批号货位库存表导出Excel中sheetName
    public static final String BATCH_NO_LIST_SHEET_NAME = "批号货位库存表";


    //常量"data"
    public static final String EXP_STRING_DATA = "data";

    //随机值范围上限
    public static final Integer EXP_INTEGER_RANDOM_UPPER_LIMIT = 10000;

    /** 导出csv 设置默认条数 */
    public static final Integer EXP_PAGE_SIZE = 5000;




}
