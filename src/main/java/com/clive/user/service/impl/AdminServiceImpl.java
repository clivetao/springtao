package com.clive.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.clive.common.consatnt.Constants;
import com.clive.common.jwt.JwtUtils;
import com.clive.user.entity.Admin;
import com.clive.user.entity.AdminRole;
import com.clive.user.entity.AdminUserDetail;
import com.clive.user.entity.Permission;
import com.clive.user.mapper.AdminMapper;
import com.clive.user.mapper.AdminRoleMapper;
import com.clive.user.mapper.PermissionMapper;
import com.clive.user.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author clive
 * @since 2020-07-13
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private AdminRoleMapper adminRoleMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailsService userDetailsService;
    @Override
    public Admin getAdminByName( String name) {
        Admin admin=adminMapper.selectOne(Wrappers.<Admin>lambdaQuery().eq(Admin::getUserName,name));
        return admin;
    }

    @Override
    public List<Permission> getPermissionList(int id) {
        List<Permission> allPermission = adminRoleMapper.getAllPermission(id);
        return allPermission;
    }

    @Override
    public Admin register(Admin admin) {
        String userName = admin.getUserName();
        Admin adminByName = getAdminByName(userName);
        if (adminByName!=null){
            return null;
        }
        String encodePassword = passwordEncoder.encode(admin.getPassword());
        admin.setPassword(encodePassword);
        adminMapper.insert(admin);
        Admin adminByName1 = getAdminByName(userName);
        Integer id = adminByName1.getId();
        Supplier<AdminRole> adminRoleSupplier=AdminRole::new;
        AdminRole adminRole = adminRoleSupplier.get();
        adminRole.setAid(id);
        adminRole.setRid(2);
        adminRoleMapper.insert(adminRole);
        return admin;
    }

    @Override
    public String login(String username, String password) {
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
        if (userDetails==null){
            return Constants.USERNAME_ERROR;
        }
        String savedPassword = userDetails.getPassword();
        if (!passwordEncoder.matches(password, savedPassword)){
         return Constants.PASSWORD_ERROR;
        }
        String token = jwtUtils.generateToken(userDetails);

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        return token;
    }

}
