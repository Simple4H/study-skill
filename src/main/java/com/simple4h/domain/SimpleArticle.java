package com.simple4h.domain;

import java.util.Date;
import lombok.Data;

/**
 * Create By Simple4H
 * Date: 2019-09-10 15:25
 */
@Data
public class SimpleArticle {
    /**
    * 文章表id
    */
    private Integer id;

    /**
    * 标题
    */
    private String title;

    /**
    * 内容
    */
    private String content;

    /**
    * 类型
    */
    private String tags;

    /**
    * 状态
    */
    private String status;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 最后一次更新时间
    */
    private Date updateTime;
}