package com.example.demo.module.${moduleName}.service;

import com.example.demo.common.BaseService;
import com.example.demo.entity.${entityName};
import com.example.demo.module.${moduleName}.param.${entityName}PageParam;

import java.io.Serializable;

/**
 * @author ${generatorName}
 * @date ${currentDate}
 */
public interface ${entityName}Service extends BaseService<${entityName}> {

	Serializable list(${entityName}PageParam param);

}
