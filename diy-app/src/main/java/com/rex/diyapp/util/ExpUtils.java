package com.rex.diyapp.util;

import com.rex.diyapp.constants.ExportConstants;
import com.rex.diyapp.entity.vo.ExpResultCommonVO;
import com.rex.diyapp.enums.ExpProcessEnum;
import com.tyche.framework.utils.OSSUtils;
import com.tyche.framework.utils.RedisUtil;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 导出功能工具类
 *
 * @author zhiqiang li
 * @since 2020/7/2
 */
public class ExpUtils {
    private ExpUtils() {
    }

    /**
     * 初始化返回参数类
     *
     * @param expFileFlag redisKey前缀标识
     * @return
     */
    public static ExpResultCommonVO initExpResult(String expFileFlag) {
        ExpResultCommonVO expResultVO = new ExpResultCommonVO();
        String redisKey = new StringBuffer(expFileFlag).append(DateUtils.getCurrDate(DateUtils.FORMAT_FIVE)).append(ThreadLocalRandom.current().nextInt(ExportConstants.EXP_INTEGER_RANDOM_UPPER_LIMIT)).toString();
        expResultVO.setExpRedisKey(redisKey);
        expResultVO.setExpStatus(ExpProcessEnum.LOAD_ING.getStatus());
        expResultVO.setExpMsg(ExpProcessEnum.LOAD_ING.getStatusDesc());
        RedisUtil redisUtil = (RedisUtil) SpringContextUtils.getBean("redisUtil");
        redisUtil.hset(redisKey, ExportConstants.EXP_STRING_DATA, expResultVO);
        return expResultVO;
    }

    /**
     * 将导出excel进度记录到redis
     *
     * @param expResultCommonVO excel导出结果集对象
     * @param expOrderDownLoadEnum 导出进度状态枚举对象
     * @param filePath 文件地址（导出成功时有该值）
     */
    public static void redisValOfExpProcess(ExpResultCommonVO expResultCommonVO, ExpProcessEnum expOrderDownLoadEnum, String filePath){
        expResultCommonVO.setExpStatus(expOrderDownLoadEnum.getStatus());
        expResultCommonVO.setExpMsg(expOrderDownLoadEnum.getStatusDesc());
        if(ExpProcessEnum.LOAD_SUCCESS.equals(expOrderDownLoadEnum)){
            expResultCommonVO.setFilePath(OSSUtils.getAbsolutePath(filePath));
        }
    }

    /**
     * 并行查询获取记录
     *
     * @param expVOs 导出数据集合
     * @param tasks 并行查询任务集合
     * @param lists 查得数据集合
     * @param <T>
     * @return
     * @throws InterruptedException
     */
    public static <T> List<T> getAllOrder(List<T> expVOs, List<Callable<List<?>[]>> tasks, List<?>[] lists) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        executorService.invokeAll(tasks);
        executorService.shutdown();

        //轮询任务是否执行完成
        while (true) {
            if (executorService.isTerminated()) {
                //查得数据结果集转换为最终导出的数据结果集
                List<T>[] queryList = (List<T>[]) lists;
                for (List<T> eleList : queryList) {
                    expVOs.addAll(eleList);
                    eleList.clear();
                }
                break;
            }
            //轮询间隔，避免过快的轮询消耗性能
            Thread.sleep(1000);
        }

        return expVOs;
    }


    /**
     * 获取文件上传到OSS的完整路径
     * @param ossDir 文件所在文件夹
     * @param sheetName sheet名
     * @return 文件全路径
     */
    public static String getFilePath(String ossDir, String sheetName){
        return new StringBuffer(ossDir).append(OSSUtils.getHashPath()).append(sheetName).append(".csv").toString();
    }

    /**
     * 获取文件上传到OSS的完整路径
     * @param ossDir 文件所在文件夹
     * @param sheetNamePre sheet名前缀
     * @return 文件全路径
     */
    public static String getFilePathOri(String ossDir, String sheetNamePre){
        String sheetName = ExcelUtils.getSheetName(sheetNamePre);
        return new StringBuffer(ossDir).append(OSSUtils.getHashPath()).append(sheetName).append(".csv").toString();
    }

}
