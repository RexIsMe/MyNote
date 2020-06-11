package com.tyche.icms.module.${moduleName}.dto;

import com.tyche.icms.entity.${entityName};

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ${generatorName}
 * @date ${currentDate}
 * @description ${tableComment}
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ${entityName}DTO extends ${entityName} {

	private static final long serialVersionUID = 1L;

}