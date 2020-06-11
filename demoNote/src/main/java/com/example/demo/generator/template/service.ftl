package com.tyche.icms.module.${moduleName}.service;

import com.tyche.icms.common.BaseService;
import com.tyche.icms.entity.${entityName};
import com.tyche.icms.module.${moduleName}.param.${entityName}PageParam;

import java.io.Serializable;

/**
 * @author ${generatorName}
 * @date ${currentDate}
 */
public interface ${entityName}Service extends BaseService<${entityName}> {

	Serializable list(${entityName}PageParam param);

}
