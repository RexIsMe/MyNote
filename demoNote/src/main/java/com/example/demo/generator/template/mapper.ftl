<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.tyche.icms.module.${moduleName}.mapper.${entityName}Mapper">

    <sql id="from">
        from ${tableName}
        <where>
            ${wheres}
        </where>
    </sql>
	<select id="pageList" resultType="com.tyche.icms.module.${moduleName}.dto.${entityName}DTO">
		select *
		<include refid="from"/>
        <if test="param.pageNo!=null and param.pageSize !=null">
            limit <#noparse>${</#noparse>(param.pageNo-1)*param.pageSize<#noparse>}</#noparse>,<#noparse>#{</#noparse>param.pageSize<#noparse>}</#noparse>
        </if>
	</select>
    <select id="pageCount" resultType="Integer">
        select count(*)
        <include refid="from"/>
    </select>

</mapper>