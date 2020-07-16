package com.clive.user.controller;


import com.clive.common.result.CommonResult;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户角色表 前端控制器
 * </p>
 *
 * @author clive
 * @since 2020-07-13
 */
@RestController
@RequestMapping("/user/role")
public class RoleController {
    @RequestMapping("/test")
    @PreAuthorize("hasAuthority('pms:product:delete')")
    public CommonResult test(){
        return CommonResult.success();
    }
}
