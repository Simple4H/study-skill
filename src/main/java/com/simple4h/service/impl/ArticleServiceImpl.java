package com.simple4h.service.impl;

import com.google.gson.Gson;
import com.simple4h.Utils.DateUtils;
import com.simple4h.domain.KafkaMessageDto;
import com.simple4h.domain.MqDto;
import com.simple4h.domain.SimpleArticle;
import com.simple4h.mapper.SimpleArticleMapper;
import com.simple4h.service.IArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Create By Simple4H
 * Date: 2019-07-09 20:52
 */
@Service
@Slf4j
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private SimpleArticleMapper simpleArticleMapper;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private Gson gson;

    public Object getAll() {
        log.info("-------------------send kafka-------------------------");
        KafkaMessageDto kafkaMessageDto = new KafkaMessageDto();
        kafkaMessageDto.setId(123L);
        MqDto mqDto = new MqDto();
        mqDto.setUsername("simple4h");
        mqDto.setPassword("123");
        kafkaMessageDto.setMessage(gson.toJson(mqDto));
        kafkaMessageDto.setSendTime(DateUtils.toLong(new Date()));
        kafkaTemplate.send("abc123", gson.toJson(kafkaMessageDto));
        AtomicReference<SimpleArticle> simpleArticle = new AtomicReference<>(new SimpleArticle());
        transactionTemplate.execute(s -> {
            simpleArticle.set(simpleArticleMapper.selectByPrimaryKey(1));
            return "ok";
        });
        return simpleArticle.get();
    }

    @Override
    public String message() {
        return "123";
    }


}
