package com.clive.user.mapper;

import com.clive.user.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 用户权限表 Mapper 接口
 * </p>
 *
 * @author clive
 * @since 2020-07-13
 */
public interface PermissionMapper extends BaseMapper<Permission> {

     Permission getPermissionList(int id);


}
