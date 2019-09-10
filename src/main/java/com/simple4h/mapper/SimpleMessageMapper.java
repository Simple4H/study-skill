package com.simple4h.mapper;

import com.simple4h.domain.SimpleMessage;

/**
 * Create By Simple4H
 * Date: 2019-09-10 15:25
 */
public interface SimpleMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SimpleMessage record);

    int insertSelective(SimpleMessage record);

    SimpleMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SimpleMessage record);

    int updateByPrimaryKey(SimpleMessage record);
}