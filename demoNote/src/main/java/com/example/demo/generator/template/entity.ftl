package com.example.demo.entity;

import javax.persistence.Table;
import com.example.demo.common.BaseEntity;
import com.example.demo.annotation.Comment;
import lombok.Data;
import lombok.EqualsAndHashCode;
${imports}
/**
 * @author ${generatorName}
 * @date ${currentDate}
 * @description ${tableComment}
 */
@Table(name = "${tableName}")
@Data
@EqualsAndHashCode(callSuper = true)
public class ${entityName} extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	${efields}

}