//package com.example.demo.module.exportamq.service.impl;
//
//import com.alibaba.excel.EasyExcel;
//import com.alibaba.excel.ExcelWriter;
//import com.alibaba.excel.support.ExcelTypeEnum;
//import com.alibaba.excel.write.builder.ExcelWriterBuilder;
//import com.alibaba.excel.write.metadata.WriteSheet;
//import com.tyche.framework.utils.OSSUtils;
//import com.tyche.icms.common.BaseServiceImpl;
//import com.tyche.icms.entity.LockSignal;
//import com.tyche.icms.enums.ExpOrderDownLoadEnum;
//import com.tyche.icms.module.order.vo.ExpOrderListResultVO;
//import com.tyche.icms.module.system.dto.LockDTO;
//import com.tyche.icms.module.system.mapper.ResourceMapper;
//import com.tyche.icms.module.system.param.LockListParam;
//import com.tyche.icms.module.test.constant.TestConstant;
//import com.tyche.icms.module.test.mapper.LockSignalMapper;
//import com.tyche.icms.module.test.param.LockSignalPageParam;
//import com.tyche.icms.module.test.service.LockSignalService;
//import com.tyche.icms.module.test.vo.ExpLockLogVO;
//import com.tyche.icms.utils.DateUtil;
//import com.tyche.icms.utils.PageUtil;
//import lombok.extern.log4j.Log4j2;
//import org.apache.commons.collections4.CollectionUtils;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.FileOutputStream;
//import java.io.Serializable;
//import java.math.BigDecimal;
//import java.util.*;
//
///**
// * @author zhangcan
// * @date 2020-05-01 00:55:33
// */
//@Log4j2
//@Service("lockSignalService")
//public class LockSignalServiceImpl extends BaseServiceImpl<LockSignal, LockSignalMapper> implements LockSignalService {
//
//	@Resource
//	private LockSignalMapper lockSignalMapper;
//
//	@Resource
//	private ResourceMapper resourceMapper;
//
//	@Override
//	protected LockSignalMapper getMapper() { return this.lockSignalMapper; }
//
//	@Override
//	public Serializable list(LockSignalPageParam param) {
//		return PageUtil.list(this.lockSignalMapper.pageList(param), param, page -> page.setTotal(this.lockSignalMapper.pageCount(param), param.getPageNo()));
//	}
//
//	@Override
//	public void getLockLog(String excelPath) {
//
//		try{
//			//创建一个list用于接收格式化后的有效数据
//			List<Map<String, Object>> result = new ArrayList<>();
//			//获取所有的锁号
//			List<String> lockNums = lockSignalMapper.getLockNum();
//			log.info(lockNums.size());
//			LockListParam lockListParam = new LockListParam();
//			lockListParam.setLockNames(lockNums);
//		List<LockDTO> lockDTOList = resourceMapper.lockList(lockListParam,null);
////			List<LockDTO> lockDTOList = resourceMapper.lockListLocal(lockListParam,null);
//			//lockDTOList.forEach(item->log.info(JSONObject.toJSONString(item)));
//			ExpLockLogVO expLockLogVO;
//			List<ExpLockLogVO> expLockLogVOList = new ArrayList<>();
//
//			LockSignalPageParam param = new LockSignalPageParam();
//			param.setLockNums(lockNums);
//			List<Map<String,Object>> signalMaps=lockSignalMapper.getSignal(new LockSignalPageParam());
//			//遍历锁号
//			for (int n = 0; n<lockNums.size(); n++) {
//				String lockNum = lockNums.get(n);
//				expLockLogVO = new ExpLockLogVO();
//				//定义一个map用于接收有效数据，并将其存到result的集合中
//				Map<String, Object> resultMap = new HashMap<>();
//				result.add(resultMap);
//				resultMap.put("lockNum", lockNum);
//				for (LockDTO lockDTO : lockDTOList) {
//					if(lockNum.equals(lockDTO.getName())){
//						expLockLogVO.setHospitalName(lockDTO.getHospitalName());
////					expLockLogVO.setDepartmentName(lockDTO.getDepartmentName());
//						expLockLogVO.setDepartmentName(getFullDepartmentName(lockDTO.getDepartmentName()));
//						expLockLogVO.setWardName(lockDTO.getWardName());
//						expLockLogVO.setCabinetName(lockDTO.getCabinetName());
//						expLockLogVO.setLockName(lockNum);
//						break;
//					}
//				}
//				//根据锁号查询平均信号强度，最低信号强度与最高信号强度
//			/*Map<String,Object> signal=lockSignalMapper.getSignal(lockNum);
//			expLockLogVO.setAvgSignal(new BigDecimal(signal.get("avgSignal").toString()));
//			expLockLogVO.setMinSignal(new BigDecimal(signal.get("minSignal").toString()));
//			expLockLogVO.setMaxSignal(new BigDecimal(signal.get("maxSignal").toString()));*/
//				if(CollectionUtils.isNotEmpty(signalMaps)){
//					for(Map<String,Object> signalMap : signalMaps){
//						if(lockNum.equals(signalMap.get("lockNum").toString())){
//							expLockLogVO.setAvgSignal(new BigDecimal(signalMap.get("avgSignal").toString()));
//							expLockLogVO.setMinSignal(new BigDecimal(signalMap.get("minSignal").toString()));
//							expLockLogVO.setMaxSignal(new BigDecimal(signalMap.get("maxSignal").toString()));
//							//根据最低信号强度与最高信号强度查询时间
//							List<String> signalInTime=lockSignalMapper.getSendTimeBySignal(signalMap);
//							expLockLogVO.setMinSignalTimes(signalInTime.toString());
//							break;
//						}
//					}
//				}
//				//resultMap.putAll(signal);
//				//resultMap.put("minSiganlTime",signalInTime);
//				LockSignalPageParam lockParam = new LockSignalPageParam();
//				lockParam.setLockNum(lockNum);
//				Map<String,Object> lostCodeTime = countLosts(lockSignalMapper.getSendTimeByLockNum(lockNum));
//				expLockLogVO.setLostCount(Integer.valueOf(lostCodeTime.get("lostCount").toString()));
//				expLockLogVO.setLostDetail(lostCodeTime.get("timeZone").toString());
//				//根据锁号计算掉线次数与时间
//				//resultMap.putAll(countLosts(lockSignalMapper.getSendTimeByLockNum(lockNum)));
//				expLockLogVOList.add(expLockLogVO);
//				log.info("###########################################");
//				log.info("################### **    "+ n +"  ** ########################");
//				log.info("###########################################");
//			}
//
//			//		expExcel(expLockLogVOList);
//			expLocalExcel(expLockLogVOList, excelPath);
//		}catch (Exception e){
//			log.error(e.getMessage());
//		}
//	}
//
//	/**
//	 * 根据departmentName补充其楼栋和楼层数据获取完整的departmentName
//	 * @param departmentName
//	 * @return
//	 */
//	public String getFullDepartmentName(String departmentName, LockDTO lockDTO){
//		String fullDepartmentName = departmentName;
//		if(TestConstant.DEPARTMENT_LIST.contains(departmentName)){
//			//位置模糊的科室
//			Iterator<Map.Entry<String, String>> it = TestConstant.DEPARTMENT_MAP.entrySet().iterator();
//			while (it.hasNext()) {
//				Map.Entry<String, String> next = it.next();
//				if(next.getKey().equals(departmentName)){
//					fullDepartmentName = departmentName + "(" + next.getValue() + ")";
//					break;
//				}
//			}
//		} else {
//			//位置明确的科室
//			fullDepartmentName = departmentName + "(" + lockDTO.getStore() + "-" + lockDTO.getFloor() + ")";
//		}
//
//		return fullDepartmentName;
//	}
//
//	/**
//	 * 根据departmentName补充其楼栋和楼层数据获取完整的departmentName
//	 * @param departmentName
//	 * @return
//	 */
//	public String getFullDepartmentName(String departmentName){
//		String fullDepartmentName = departmentName;
//		if(TestConstant.DEPARTMENT_LIST.contains(departmentName)){
//			//位置模糊的科室
//			Iterator<Map.Entry<String, String>> it = TestConstant.DEPARTMENT_MAP.entrySet().iterator();
//			while (it.hasNext()) {
//				Map.Entry<String, String> next = it.next();
//				if(next.getKey().equals(departmentName)){
//					fullDepartmentName = departmentName + "(" + next.getValue() + ")";
//					break;
//				}
//			}
//		} else {
//			//位置明确的科室
//			fullDepartmentName = departmentName ;
//		}
//
//		return fullDepartmentName;
//	}
//
//	private void expLocalExcel(List<ExpLockLogVO> expLockLogVOList, String excelPath){
//		try {
//			String sheetName = "explocklog";
//			ExcelWriterBuilder excelWriterBuilder = new ExcelWriterBuilder();
//			excelWriterBuilder.needHead(true);
//			excelWriterBuilder.head(ExpLockLogVO.class);
//			excelWriterBuilder.excelType(ExcelTypeEnum.XLSX);
//			FileOutputStream outputStream = new FileOutputStream(excelPath);
//			excelWriterBuilder.file(outputStream);
//			excelWriterBuilder.sheet(sheetName);
//			excelWriterBuilder.sheet();
//			ExcelWriter excelWriter = excelWriterBuilder.build();
//			WriteSheet writeSheet = EasyExcel.writerSheet(sheetName).build();
//			Map<Integer, Integer> columnWidthMap = initColumnWidth();
//			writeSheet.setColumnWidthMap(columnWidthMap);
//			excelWriter.write(expLockLogVOList, writeSheet);
//			excelWriter.finish();
//			outputStream.flush();
//		} catch (Exception e) {
//			log.error("导出 csv 失败", e);
//		}
//	}
//
//	private void expExcel(List<ExpLockLogVO> expLockLogVOList){
//		ExpOrderListResultVO expOrderListResult = new ExpOrderListResultVO();
//		expOrderListResult.setExpStatus(ExpOrderDownLoadEnum.LOAD_ERROR.getStatus());
//		expOrderListResult.setExpMsg(ExpOrderDownLoadEnum.LOAD_ERROR.getStatusDesc());
//		try {
//			String sheetName = "explocklog";
//			ExcelWriterBuilder excelWriterBuilder = new ExcelWriterBuilder();
//			excelWriterBuilder.head(ExpLockLogVO.class);
//			excelWriterBuilder.excelType(ExcelTypeEnum.XLSX);
//			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//			excelWriterBuilder.file(outputStream);
//			excelWriterBuilder.needHead(true);
//			excelWriterBuilder.sheet(sheetName);
//			excelWriterBuilder.sheet();
//			ExcelWriter excelWriter = excelWriterBuilder.build();
//			WriteSheet writeSheet = EasyExcel.writerSheet(sheetName).build();
//			Map<Integer, Integer> columnWidthMap = initColumnWidth();
//			writeSheet.setColumnWidthMap(columnWidthMap);
//			excelWriter.write(expLockLogVOList, writeSheet);
//			excelWriter.finish();
//			outputStream.flush();
//			log.info("写入OSS 服务器");
//			writerOss(new StringBuffer(OSSUtils.MEMBER_PATH).append(OSSUtils.getHashPath()).append(sheetName).append(".csv").toString(), outputStream,expOrderListResult);
//		} catch (Exception e) {
//			log.error("导出 csv 失败", e);
//		}
//	}
//
//	/**
//	 * csv文件写入OSS 服务器
//	 *
//	 * @param filePath           需要写入的文件路径
//	 * @param outputStream       输出IO 流
//	 * @param expOrderListResult 结果集
//	 */
//	private void writerOss(String filePath, ByteArrayOutputStream outputStream, ExpOrderListResultVO expOrderListResult) {
//		if (OSSUtils.upFile(filePath, new ByteArrayInputStream(outputStream.toByteArray()), 0)) {
//			log.info("导出CSV文件路径 ::: {} ", OSSUtils.getAbsolutePath(filePath));
//			expOrderListResult.setExpStatus(ExpOrderDownLoadEnum.LOAD_SUCCESS.getStatus());
//			expOrderListResult.setFilePath(OSSUtils.getAbsolutePath(filePath));
//			expOrderListResult.setExpMsg(ExpOrderDownLoadEnum.LOAD_SUCCESS.getStatusDesc());
//		}
//	}
//
//	/**
//	 * 初始化csv 列宽
//	 *
//	 * @return
//	 */
//	private Map<Integer, Integer> initColumnWidth() {
//		Map<Integer, Integer> columnWidthMap = new HashMap<>();
//		columnWidthMap.put(0, 25 * 256);
//		columnWidthMap.put(1, 25 * 256);
//		columnWidthMap.put(2, 25 * 256);
//		columnWidthMap.put(3, 25 * 256);
//		columnWidthMap.put(4, 15 * 256);
//		columnWidthMap.put(5, 15 * 256);
//		columnWidthMap.put(6, 15 * 256);
//		columnWidthMap.put(7, 15 * 256);
//		columnWidthMap.put(8, 35 * 256);
//		columnWidthMap.put(9, 25 * 256);
//		columnWidthMap.put(10, 250 * 256);
//		return columnWidthMap;
//	}
//
//	//根据时间算出掉线次数与对应的时间点
//	private Map<String,Object> countLosts(List<Date> dates){
//		Map<String,Object> result=new HashMap<>();
//		int count=0;
//		List<Map<String,Object>> list=new ArrayList<>();
//		for(int i=0,sizes=dates.size()-1;i<sizes;i++){
//			if(dates.get(i+1).getTime()-dates.get(i).getTime()>=600000L){
//				Map<String,Object> paraMap=new HashMap<>();
//				count++;
//				paraMap.put("startTime", DateUtil.dateToString(dates.get(i), DateUtil.FORMAT_ONE));
//				paraMap.put("endTime", DateUtil.dateToString(dates.get(i+1), DateUtil.FORMAT_ONE)+"; ");
//				list.add(paraMap);
//			}
//		}
//		result.put("lostCount",count);
//		result.put("timeZone",list);
//		return result;
//	}
//
//}
