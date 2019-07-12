package com.simple4h.mapper;

import com.simple4h.domain.SimpleArticle;

/**
 * Create By Simple4H
 * Date: 2019-07-09 20:51
 */
public interface SimpleArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SimpleArticle record);

    int insertSelective(SimpleArticle record);

    SimpleArticle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SimpleArticle record);

    int updateByPrimaryKey(SimpleArticle record);
}