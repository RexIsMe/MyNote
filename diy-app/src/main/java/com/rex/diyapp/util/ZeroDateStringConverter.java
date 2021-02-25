package com.rex.diyapp.util;

import com.alibaba.excel.converters.date.DateStringConverter;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.alibaba.excel.util.DateUtils;

import java.util.Date;

/**
 * 日期转换器
 * Created by zhugc on 2020/9/1-14:01.
 */
public class ZeroDateStringConverter extends DateStringConverter {

    @Override
    public CellData convertToExcelData(Date value, ExcelContentProperty contentProperty,
                                       GlobalConfiguration globalConfiguration) {
        if(value == null || value.equals(new Date(0))){
            return new CellData("");
        }
        if (contentProperty == null || contentProperty.getDateTimeFormatProperty() == null) {
            return new CellData(DateUtils.format(value, "yyyy-MM-dd"));
        } else {
            return new CellData(DateUtils.format(value, contentProperty.getDateTimeFormatProperty().getFormat()));
        }
    }

}
