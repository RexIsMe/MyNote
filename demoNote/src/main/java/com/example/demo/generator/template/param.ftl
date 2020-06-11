package com.tyche.icms.module.${moduleName}.param;

import com.tyche.icms.entity.${entityName};
import com.tyche.framework.common.BaseParam;
import com.tyche.icms.annotation.Comment;
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