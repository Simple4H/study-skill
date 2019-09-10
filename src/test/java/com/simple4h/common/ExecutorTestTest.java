package com.simple4h.common;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * Create By Simple4H
 * Date: 2019-09-10 15:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ExecutorTestTest {

    @Autowired
    private Gson gson;

    @Test
    public void test() {
        String s = "a|b|c|d|e|f|a|e|g";
        String b = "a,b,c,d,e,f,a";
        Set<String> strSet = Arrays.stream(s.split("")).map(String::trim).collect(Collectors.toSet());
        System.out.println(gson.toJson(strSet.size()));
        System.out.println(gson.toJson(strSet));
    }

}