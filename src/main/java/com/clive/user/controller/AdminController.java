package com.clive.user.controller;


import com.clive.common.consatnt.Constants;
import com.clive.common.result.CommonResult;
import com.clive.user.entity.Admin;
import com.clive.user.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author clive
 * @since 2020-07-13
 */
@RestController
@RequestMapping("/user")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public CommonResult login(@RequestBody Admin admin){
        String name= admin.getUserName();
        String password = admin.getPassword();
        String login = adminService.login(name, password);
        if (login.equals(Constants.USERNAME_ERROR)){
            return CommonResult.fail(Constants.USERNAME_ERROR);
        }
        if (login.equals(Constants.PASSWORD_ERROR)){
            return CommonResult.fail(Constants.PASSWORD_ERROR);
        }
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("token",login);
        objectObjectHashMap.put("header",tokenHead);
        return CommonResult.success(objectObjectHashMap);
    }


    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public CommonResult register(@RequestBody Admin admin){
        Admin register = adminService.register(admin);
        if (register!=null){
          return   CommonResult.success("注册成功");
        }
        return CommonResult.fail("注册失败，用户名重复");
    }

}
