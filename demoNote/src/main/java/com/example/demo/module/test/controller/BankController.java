package com.example.demo.module.test.controller;

import com.example.demo.module.test.dto.BankDTO;
import com.example.demo.module.test.param.BankPageParam;
import com.example.demo.module.test.service.BankService;
import com.example.demo.common.BaseController;
import com.example.demo.common.OsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.extern.log4j.Log4j2;

/**
 * @author lizhiqiang
 * @date 2021-07-27 15:16:46
 */
@Log4j2
@RequestMapping("bank")
@RestController
public class BankController extends BaseController {

    @Autowired
    private BankService bankService;

    @GetMapping("list")
    public OsResult list(BankPageParam param) {
        return super.success(this.bankService.list(param));
    }

    @PostMapping("save")
    public OsResult save(BankDTO bank) {
        this.bankService.insertSelective(bank);
        return super.msg("新增成功");
    }

    @PostMapping("delete")
    public OsResult delete(BankDTO bank) {
        this.bankService.deleteByPrimaryKey(bank.getId());
        return super.msg("删除成功");
    }

    @PostMapping("update")
    public OsResult update(BankDTO bank) {
        this.bankService.updateByPrimaryKeySelective(bank);
        return super.msg("更新成功");
    }

}
