package com.simple4h.service.impl;

import com.simple4h.mapper.SimpleArticleMapper;
import com.simple4h.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create By Simple4H
 * Date: 2019-09-10 15:37
 */
@Service
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private SimpleArticleMapper articleMapper;

    @Override
    public List<String> getAllTitle() {
        return articleMapper.getAllTitle();
    }

    @Override
    public List<String> getAllContent() {
        return articleMapper.getAllContent();
    }
}
