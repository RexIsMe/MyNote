package com.example.demo.module.${moduleName}.service.impl;

import com.example.demo.module.${moduleName}.mapper.${entityName}Mapper;
import com.example.demo.module.${moduleName}.service.${entityName}Service;
import com.example.demo.common.BaseServiceImpl;
import com.example.demo.entity.${entityName};
import com.example.demo.module.${moduleName}.param.${entityName}PageParam;
import com.example.demo.utils.PageUtil;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @author ${generatorName}
 * @date ${currentDate}
 */
@Service("${packageName}Service")
public class ${entityName}ServiceImpl extends BaseServiceImpl<${entityName}, ${entityName}Mapper> implements ${entityName}Service {

	@Resource
	private ${entityName}Mapper ${packageName}Mapper;
	
	@Override
	protected ${entityName}Mapper getMapper() { return this.${packageName}Mapper; }

	@Override
	public Serializable list(${entityName}PageParam param) {
		return PageUtil.list(this.${packageName}Mapper.pageList(param), param, page -> page.setTotal(this.${packageName}Mapper.pageCount(param), param.getPageNo()));
	}
	
}
