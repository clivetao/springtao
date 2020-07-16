package com.clive.user.service.impl;

import com.clive.user.entity.AdminPermission;
import com.clive.user.mapper.AdminPermissionMapper;
import com.clive.user.service.AdminPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户和权限关系表 服务实现类
 * </p>
 *
 * @author clive
 * @since 2020-07-13
 */
@Service
public class AdminPermissionServiceImpl extends ServiceImpl<AdminPermissionMapper, AdminPermission> implements AdminPermissionService {

}
