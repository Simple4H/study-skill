package com.simple4h.entity;

import lombok.Data;

/**
 * Create By Simple4H
 * Date: 2019-05-31 14:33
 */
@Data
public class User {

    private Integer id;

    private String username;

    private String password;

    public User() {
    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
