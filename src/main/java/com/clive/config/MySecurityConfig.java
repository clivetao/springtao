package com.clive.config;


import com.clive.framework.filter.JwtAuthenticationTokenFilter;
import com.clive.framework.filter.JwtFilter;
import com.clive.framework.handler.ResetAccessDeniedHandler;
import com.clive.framework.handler.ResultEntryPoint;
import com.clive.user.entity.Admin;
import com.clive.user.entity.AdminUserDetail;
import com.clive.user.entity.Permission;
import com.clive.user.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //基于表达式的注解
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Autowired
    private ResultEntryPoint resultEntryPoint;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //获取数据库的账号密码
        auth.userDetailsService(userDetailsService())
                //获取加密算法
                .passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js"
                        )
                .permitAll()
                .antMatchers("/user/login","/user/register","/druid")
                .permitAll()
                .antMatchers(HttpMethod.OPTIONS)
                .permitAll()
                .anyRequest()
                .authenticated();
        http.addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);
        http.headers().cacheControl();  //return 一个 cacheControl.eable(),可以在请求头里面添加Cache-controller
        http.exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler) //访问被拒绝没有权限
                .authenticationEntryPoint(resultEntryPoint); //验证错误

    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return username -> {
            Admin adminByName = adminService.getAdminByName(username);
            if(adminByName!=null) {
                List<Permission> permissionList = adminService.getPermissionList(adminByName.getId());
                return new AdminUserDetail(adminByName,permissionList);
            }
            throw new UsernameNotFoundException("用户账号或者密码错误");
        };
    }


    @Bean
    public JwtFilter jwtFilter(){
        return new JwtFilter();
    }

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
        return  new JwtAuthenticationTokenFilter();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
