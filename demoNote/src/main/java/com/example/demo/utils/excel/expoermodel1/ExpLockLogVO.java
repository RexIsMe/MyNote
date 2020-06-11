package com.example.demo.utils.excel.expoermodel1;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Auther: zhang can
 * @Date: 2019年09月26日
 */
@Data
public class ExpLockLogVO implements Serializable {
    @ExcelProperty(value = "所属医院", index = 0)
    private String hospitalName;
    @ExcelProperty(value = "科室", index = 1)
    private String departmentName;
    @ExcelProperty(value = "病房", index = 2)
    private String wardName;
    @ExcelProperty(value = "陪护柜编号", index = 3)
    private String cabinetName;
    @ExcelProperty(value = "智能锁编号", index = 4)
    private String lockName;
    @ExcelProperty(value = "平均信号强度", index = 5)
    private BigDecimal avgSignal;
    @ExcelProperty(value = "最小信号强度", index = 6)
    private BigDecimal minSignal;
    @DateTimeFormat(value = "yyyy-MM-dd HH:mm:ss")
    @ExcelProperty(value = "最小信号强度时间", index = 7)
    private String minSignalTimes;
    @ExcelProperty(value = "最大信号强度", index = 8)
    private BigDecimal maxSignal;
    @ExcelProperty(value = "断线次数", index = 9)
    private Integer lostCount;
    @ExcelProperty(value = "断线详情", index = 10)
    private String lostDetail;

}
