package com.tyche.icms.module.${moduleName}.mapper;

import com.tyche.icms.module.${moduleName}.dto.${entityName}DTO;
import com.tyche.icms.common.BaseMapper;
import com.tyche.icms.entity.${entityName};
import com.tyche.icms.module.${moduleName}.param.${entityName}PageParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ${generatorName}
 * @date ${currentDate}
 */
public interface ${entityName}Mapper extends BaseMapper<${entityName}> {

	List<${entityName}DTO> pageList(@Param("param") ${entityName}PageParam param);

	Integer pageCount(@Param("param") ${entityName}PageParam param);

}