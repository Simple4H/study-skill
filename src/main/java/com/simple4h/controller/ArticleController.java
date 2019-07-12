package com.simple4h.controller;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.simple4h.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Create By Simple4H
 * Date: 2019-07-09 20:55
 */
@Controller
@RequestMapping("/a")
public class ArticleController {

    @Autowired
    private IArticleService iArticleService;

    @ResponseBody
    @RequestMapping("/a")
    private void send() {
        iArticleService.getAll();
    }

}
