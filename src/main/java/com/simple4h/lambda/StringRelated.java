package com.simple4h.lambda;


import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create By Simple4H
 * Date: 2019-05-31 16:11
 */
@Slf4j
public class StringRelated {

    // idsStr转换成List<Integer>
    public static void main(String[] args) {
        String idsStr = "1,2,3,4,4,5,6,7,88,123";
        // 字符串替换
        String newstr = idsStr.replace("1", "123");

        // 获取文件后缀名
        String fileName = "abc.txt";
        String newFileName = fileName.substring(fileName.lastIndexOf(".") + 1);
        log.warn("newFileName:{}", newFileName);
        List<Integer> ids = Arrays.stream(newstr.split(",")).map(Integer::valueOf).collect(Collectors.toList());
        log.warn("ids:{}", ids);
    }
}
