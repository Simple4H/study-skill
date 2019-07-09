package com.simple4h.service.impl;

import com.simple4h.domain.SimpleArticle;
import com.simple4h.mapper.SimpleArticleMapper;
import com.simple4h.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Create By Simple4H
 * Date: 2019-07-09 20:52
 */
@Service
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private SimpleArticleMapper simpleArticleMapper;

    @Autowired
    private TransactionTemplate transactionTemplate;


    public Object getAll() {
        AtomicReference<SimpleArticle> simpleArticle = new AtomicReference<>(new SimpleArticle());
        transactionTemplate.execute(s -> {
            simpleArticle.set(simpleArticleMapper.selectByPrimaryKey(1));
            return "ok";
        });
        return simpleArticle.get();
    }
}
