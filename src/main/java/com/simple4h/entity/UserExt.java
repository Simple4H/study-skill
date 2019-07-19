package com.simple4h.entity;

import lombok.Data;

import java.util.Date;

/**
 * Create By Simple4H
 * Date: 2019-05-31 14:34
 */
@Data
public class UserExt {

    private Integer userId;

    private Date birthday;

    private String phone;

    public UserExt() {
    }

    public UserExt(Integer userId, Date birthday, String phone) {
        this.userId = userId;
        this.birthday = birthday;
        this.phone = phone;
    }
}
