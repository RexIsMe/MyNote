package com.example.demo.module.${moduleName}.param;

import com.example.demo.common.PageListParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.example.demo.annotation.Comment;
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
