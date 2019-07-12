package com.simple4h.service.impl;

import com.simple4h.Utils.DateUtils;
import com.simple4h.service.IArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Create By Simple4H
 * Date: 2019-07-09 20:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceImplTest {

    @Autowired
    private IArticleService iArticleService;

    @Test
    public void getAll() {
        System.out.println(iArticleService.getAll());
    }

    @Test
    public void testDateTime() {
        String time = "2010-11-21 11:11:11";
//        Date date = DateUtils.pa(time);
//        System.out.println(date);
    }
}