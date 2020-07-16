package com.clive.user.service.impl;

import com.clive.user.entity.Role;
import com.clive.user.mapper.RoleMapper;
import com.clive.user.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
 * @author clive
 * @since 2020-07-13
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
