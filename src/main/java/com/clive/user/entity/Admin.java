package com.clive.user.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 后台用户表
 * </p>
 *
 * @author clive
 * @since 2020-07-13
 */
@TableName("user_admin")
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名字
     */
    private String userName;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户电话
     */
    private String phone;

    /**
     * 邮箱名
     */
    private String email;

    /**
     * 邮箱名
     */
    private LocalDateTime createAt;

    /**
     * 登录时间
     */
    private LocalDateTime updateAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Admin{" +
            "id=" + id +
            ", userName=" + userName +
            ", password=" + password +
            ", phone=" + phone +
            ", email=" + email +
            ", createAt=" + createAt +
            ", updateAt=" + updateAt +
        "}";
    }
}
