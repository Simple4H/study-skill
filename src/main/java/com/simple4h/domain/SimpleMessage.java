package com.simple4h.domain;

import java.util.Date;
import lombok.Data;

/**
 * Create By Simple4H
 * Date: 2019-09-10 15:25
 */
@Data
public class SimpleMessage {
    /**
    * 信息表id
    */
    private Integer id;

    /**
    * 用户姓名
    */
    private String name;

    /**
    * 邮箱
    */
    private String email;

    /**
    * 手机
    */
    private String phone;

    /**
    * 信息
    */
    private String message;

    /**
    * 创建时间
    */
    private Date createTime;
}