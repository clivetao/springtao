package com.clive.user.service.impl;

import com.clive.user.entity.AdminRole;
import com.clive.user.mapper.AdminRoleMapper;
import com.clive.user.service.AdminRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户和角色关系表 服务实现类
 * </p>
 *
 * @author clive
 * @since 2020-07-13
 */
@Service
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole> implements AdminRoleService {

}
