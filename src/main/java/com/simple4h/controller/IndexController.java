package com.simple4h.controller;

import com.simple4h.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Create By Simple4H
 * Date: 2019-09-10 15:45
 */
@RestController
@RequestMapping("/index/")
public class IndexController {

    @Autowired
    private IArticleService iArticleService;

    @GetMapping("index")
    public Object index() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Callable<List> titleCallable = () -> iArticleService.getAllTitle();

        Callable<List> contentCallable = () -> iArticleService.getAllContent();
        return null;
    }
}
