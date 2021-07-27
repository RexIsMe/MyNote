package com.example.demo.module.${moduleName}.param;

import com.example.demo.entity.${entityName};
import com.example.demo.common.BaseParam;
import com.example.demo.annotation.Comment;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ${generatorName}
 * @date ${currentDate}
 * @description ${tableComment}
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ${entityName}Param extends BaseParam {

	private static final long serialVersionUID = 1L;

}