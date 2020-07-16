package com.clive.user.service.impl;

import com.clive.user.entity.Permission;
import com.clive.user.mapper.PermissionMapper;
import com.clive.user.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户权限表 服务实现类
 * </p>
 *
 * @author clive
 * @since 2020-07-13
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

}
