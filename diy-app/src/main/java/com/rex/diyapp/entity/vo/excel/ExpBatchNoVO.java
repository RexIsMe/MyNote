package com.rex.diyapp.entity.vo.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.rex.diyapp.util.ZeroDateStringConverter;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 批号货位库存列表导出Excel-sheet表头类
 * @author lizhiqiang
 * @since 2020/7/6
 */
@Data
public class ExpBatchNoVO {

    @ExcelProperty(value = "业主名称", index = 0)
    private String ownerName;
    @ExcelProperty(value = "产品代码", index = 1)
    private String commodityCode;
    @ExcelProperty(value = "产品名称", index = 2)
    private String commodityName;
    @ExcelProperty(value = "分类一级", index = 3)
    private String classifyIdLevel1;
    @ExcelProperty(value = "分类二级", index = 4)
    private String classifyIdLevel2;
    @ExcelProperty(value = "型号、规格", index = 5)
    private String commoditySpec;
    @ExcelProperty(value = "包装单位名称", index = 6)
    private String packageUnitName;
    @ExcelProperty(value = "产品品牌", index = 7)
    private String brandName;
    @ExcelProperty(value = "注册证编码", index = 8)
    private String registerNumber;
    @ExcelProperty(value = "注册证名称", index = 9)
    private String registerName;
    @ExcelProperty(value = "库存数量", index = 10)
    private BigDecimal inventoryNumber;
    @ExcelProperty(value = "批号", index = 11)
    private String batchNo;
    @ExcelProperty(value = "效期", index = 12)
//    @DateTimeFormat(value = "yyyy-MM-dd")
//    private Date effectiveDate;
    private String effectiveDate;
//    @ExcelProperty(value = "生产日期", index = 13,converter = ZeroDateStringConverter.class)
//    private Date producedDate;
    @ExcelProperty(value = "生产日期", index = 13)
    private String producedDate;
    @ExcelProperty(value = "逻辑区域名称", index = 14)
    private String logicAreaName;
    @ExcelProperty(value = "货位", index = 15)
    private String  goodsLocation;
    @ExcelProperty(value = "仓库名称", index = 16)
    private String warehouseName;
    @ExcelProperty(value = "供应商名称", index = 17)
    private String supplierName;
    @ExcelProperty(value = "生产厂家", index = 18)
    private String manufacturerName;

}