package com.clive.user.service;

import com.clive.user.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.clive.user.entity.Permission;

import java.util.List;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author clive
 * @since 2020-07-13
 */
public interface AdminService extends IService<Admin> {

    public Admin getAdminByName(String name);

    public List<Permission> getPermissionList(int id);

    public Admin register(Admin admin);

    public  String login(String username,String password);

}
