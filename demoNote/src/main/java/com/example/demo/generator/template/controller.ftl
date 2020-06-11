package com.tyche.icms.module.${moduleName}.controller;

import com.tyche.apiframework.common.constant.AuthorityTypeEnum;
import com.tyche.apiframework.core.context.handle.annotation.PermissionBlock;
import com.tyche.icms.module.${moduleName}.dto.${entityName}DTO;
import com.tyche.icms.module.${moduleName}.param.${entityName}PageParam;
import com.tyche.icms.module.${moduleName}.service.${entityName}Service;
import com.tyche.icms.common.BaseController;
import com.tyche.framework.common.OsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.extern.log4j.Log4j2;

/**
 * @author ${generatorName}
 * @date ${currentDate}
 */
@Log4j2
@RequestMapping("${prefixUrl}")
@RestController
public class ${entityName}Controller extends BaseController {

    @Autowired
    private ${entityName}Service ${packageName}Service;

    @GetMapping("list")
    @PermissionBlock(AuthorityTypeEnum.NoAuthority)
    public OsResult list(${entityName}PageParam param) {
        return super.success(this.${packageName}Service.list(param));
    }

    @PostMapping("save")
    @PermissionBlock
    public OsResult save(${entityName}DTO ${packageName}) {
        this.${packageName}Service.insertSelective(${packageName});
        return super.msg("新增成功");
    }

    @PostMapping("delete")
    @PermissionBlock
    public OsResult delete(${entityName}DTO ${packageName}) {
        this.${packageName}Service.deleteByPrimaryKey(${packageName}.getId());
        return super.msg("删除成功");
    }

    @PostMapping("update")
    @PermissionBlock
    public OsResult update(${entityName}DTO ${packageName}) {
        this.${packageName}Service.updateByPrimaryKeySelective(${packageName});
        return super.msg("更新成功");
    }

}
