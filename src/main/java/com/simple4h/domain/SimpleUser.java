package com.simple4h.domain;

import java.util.Date;
import lombok.Data;

/**
 * Create By Simple4H
 * Date: 2019-09-10 15:25
 */
@Data
public class SimpleUser {
    /**
    * 管理员表id
    */
    private Integer id;

    /**
    * 账号
    */
    private String username;

    /**
    * 密码
    */
    private String password;

    /**
    * 邮箱
    */
    private String email;

    /**
    * 状态
    */
    private Integer status;

    /**
    * 权限
    */
    private Integer authority;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 最后一次登录时间
    */
    private Date updateTime;
}