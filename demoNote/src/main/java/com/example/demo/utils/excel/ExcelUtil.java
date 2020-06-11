package com.example.demo.utils.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import lombok.extern.log4j.Log4j2;

import java.io.FileOutputStream;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Rex
 * @title: ExcelUtil
 * @projectName demoNote
 * @description: Excel相关工具类
 * @date 2020/5/815:47
 */
@Log4j2
public class ExcelUtil {

    public  static <T> void expLocalExcel(Class<T> claz, List<T> expLockLogVOList,  Map<Integer, Integer> columnWidthMap, String excelPath, String sheetName){
        try {
            sheetName = sheetName.isEmpty()?"sheet1":sheetName;

            ExcelWriterBuilder excelWriterBuilder = new ExcelWriterBuilder();
            excelWriterBuilder.needHead(true);
            excelWriterBuilder.head(claz);
            excelWriterBuilder.excelType(ExcelTypeEnum.XLSX);
            FileOutputStream outputStream = new FileOutputStream(excelPath);
            excelWriterBuilder.file(outputStream);
            excelWriterBuilder.sheet(sheetName);
            excelWriterBuilder.sheet();

            ExcelWriter excelWriter = excelWriterBuilder.build();
            WriteSheet writeSheet = EasyExcel.writerSheet(sheetName).build();
            writeSheet.setColumnWidthMap(columnWidthMap);
            excelWriter.write(expLockLogVOList, writeSheet);
            excelWriter.finish();
            outputStream.flush();
        } catch (Exception e) {
            log.error("导出 csv 失败", e);
        }
    }



}
