package com.clive.user.mapper;

import com.clive.user.entity.AdminRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.clive.user.entity.Permission;

import java.util.List;

/**
 * <p>
 * 用户和角色关系表 Mapper 接口
 * </p>
 *
 * @author clive
 * @since 2020-07-13
 */
public interface AdminRoleMapper extends BaseMapper<AdminRole> {
    List<Permission> getAllPermission(int id);
}
