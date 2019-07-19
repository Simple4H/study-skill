package com.simple4h.service.impl;

import com.simple4h.service.IArticleService;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        iArticleService.getAll();
    }

    @Test
    public void testDateTime() {
        String time = "2010-11-21 11:11:11";
//        Date date = DateUtils.pa(time);
//        System.out.println(date);
    }

    @Test
    public void testString() {
        String a = "文涛";
        String b = "陈新谋";
        String c = "欧阳大大";
        String substring1 = "*" + StringUtils.substring(a, 1);
        String substring2 = "*" + StringUtils.substring(b, 1);
        String substring3 = "*" + StringUtils.substring(c, 2);
        String substring4 = "**" + StringUtils.substring(c, 2);
        System.out.println(substring1);
        System.out.println(substring2);
        System.out.println(substring3);
        System.out.println(substring4);
    }
}