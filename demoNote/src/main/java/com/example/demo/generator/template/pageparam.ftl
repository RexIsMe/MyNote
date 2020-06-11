package com.tyche.icms.module.${moduleName}.param;

import com.tyche.icms.common.PageListParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.tyche.icms.annotation.Comment;
${imports}
/**
 * @author ${generatorName}
 * @date ${currentDate}
 * @description ${tableComment}
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ${entityName}PageParam extends PageListParam {

    private static final long serialVersionUID = 1L;

    ${efields}
}
