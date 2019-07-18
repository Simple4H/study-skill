package com.simple4h.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Create By Simple4H
 * Date: 2019-07-09 20:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceImplTest {

    @Test
    public void testString() {
        String ORDER_STATUS_LOCK = "wx_user_export:%s:%d:%d";
        String format = String.format(ORDER_STATUS_LOCK, "simple4h", 1, 2);
        System.out.println(format);
    }
}