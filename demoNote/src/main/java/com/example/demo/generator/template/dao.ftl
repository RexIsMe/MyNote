package com.example.demo.module.${moduleName}.mapper;

import com.example.demo.module.${moduleName}.dto.${entityName}DTO;
import com.example.demo.common.BaseMapper;
import com.example.demo.entity.${entityName};
import com.example.demo.module.${moduleName}.param.${entityName}PageParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ${generatorName}
 * @date ${currentDate}
 */
@Mapper
public interface ${entityName}Mapper extends BaseMapper<${entityName}> {

	List<${entityName}DTO> pageList(@Param("param") ${entityName}PageParam param);

	Integer pageCount(@Param("param") ${entityName}PageParam param);

}