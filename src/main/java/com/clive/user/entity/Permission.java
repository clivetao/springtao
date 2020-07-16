package com.clive.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 用户权限表
 * </p>
 *
 * @author clive
 * @since 2020-07-13
 */
@TableName("user_permission")
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 父级权限
     */
    private Integer pid;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限的值
     */
    private String value;

    /**
     * 0->菜单，1->目录，2->按钮
     */
    private Integer type;

    /**
     * 前端资源路径
     */
    private String url;

    /**
     * 创建时间
     */
    private LocalDateTime createAt;

    /**
     * 启用状态，0->不启用，1->启用
     */
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Permission{" +
            "id=" + id +
            ", pid=" + pid +
            ", name=" + name +
            ", value=" + value +
            ", type=" + type +
            ", url=" + url +
            ", createAt=" + createAt +
            ", status=" + status +
        "}";
    }
}
