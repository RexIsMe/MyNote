package com.rex.diyapp.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.tyche.framework.utils.OSSUtils;
import lombok.extern.log4j.Log4j2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

/**
 * @author Li zhiqiang
 *
 * @description: Excel相关工具类
 * @date 2020/5/27 15:47
 */
@Log4j2
public class ExcelUtils {

    /**
     * 导出记录到Excel，并上传到OSS
     * @param claz 导出Excel的表头对象
     * @param expLockLogVOList 导出记录
     * @param columnWidthMap sheet格式
     * @param filePath 文件路径
     * @param sheetName sheet名
     * @param <T> sheet表头类型
     * @return 执行结果
     */
    public  static <T> Boolean expExcel(Class<T> claz, List<T> expLockLogVOList, Map<Integer, Integer> columnWidthMap, String filePath, String sheetName){
        try {
            sheetName = sheetName.isEmpty()?"sheet1":sheetName;

            ExcelWriterBuilder excelWriterBuilder = new ExcelWriterBuilder();
            excelWriterBuilder.needHead(true);
            excelWriterBuilder.head(claz);
            excelWriterBuilder.excelType(ExcelTypeEnum.XLSX);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            excelWriterBuilder.file(outputStream);
            excelWriterBuilder.sheet(sheetName);
            excelWriterBuilder.sheet();

            ExcelWriter excelWriter = excelWriterBuilder.build();
            WriteSheet writeSheet = EasyExcel.writerSheet(sheetName).build();
            writeSheet.setColumnWidthMap(columnWidthMap);
            excelWriter.write(expLockLogVOList, writeSheet);
            excelWriter.finish();
            outputStream.flush();

            if (OSSUtils.upFile(filePath, new ByteArrayInputStream(outputStream.toByteArray()), 0)) {
                return true;
            }
        } catch (Exception e) {
            log.error("导出 csv 失败", e);
        }

        return false;
    }


    /**
     * 生成Excel的 sheetName
     * @param sheetNamePrefix sheetName前缀
     * @return
     */
    public static String getSheetName(String sheetNamePrefix){
        return new StringBuffer(sheetNamePrefix).append(DateUtils.getCurrDate(DateUtils.FORMAT_THREE)).toString();
    }

    /**
     * 导出记录到Excel，并上传到OSS
     * @param claz 导出Excel的表头对象
     * @param expLockLogVOList 导出记录
     * @param columnWidthMap sheet格式
     * @param ossDir 文件所在文件夹
     * @param sheetNamePrefix sheet名前缀
     * @param <T> sheet表头类型
     * @return 执行结果
     */
    public static <T> Boolean expExcelOri(Class<T> claz, List<T> expLockLogVOList,  Map<Integer, Integer> columnWidthMap, String ossDir, String sheetNamePrefix){
        String sheetName = getSheetName(sheetNamePrefix);
        String filePath = ExpUtils.getFilePath(ossDir, sheetName);
        return expExcel(claz, expLockLogVOList, columnWidthMap, filePath, sheetName);
    }
}
