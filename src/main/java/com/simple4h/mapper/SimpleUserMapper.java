package com.simple4h.mapper;

import com.simple4h.domain.SimpleUser;

/**
 * Create By Simple4H
 * Date: 2019-09-10 15:25
 */
public interface SimpleUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SimpleUser record);

    int insertSelective(SimpleUser record);

    SimpleUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SimpleUser record);

    int updateByPrimaryKey(SimpleUser record);
}