package com.clive;

import com.clive.common.jwt.JwtUtils;
import com.clive.user.entity.Admin;
import com.clive.user.entity.AdminUserDetail;
import com.clive.user.entity.Permission;
import com.clive.user.service.AdminService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
class ApplicationTests {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AdminService adminService;

    @Test
    void contextLoads() {
        Admin admin = adminService.getAdminByName("沈美芳");
        System.out.println(admin);

    }

}
