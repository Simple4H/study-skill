package com.simple4h;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudyApplicationTests {

    @Test
    public void contextLoads() {
        String a = "a";
        String b = "b";
        System.out.println(a + b);
    }

    @Test
    public void stream() {
        List<Integer> lists = Lists.newArrayList(1, 3, 4, 5, 6, 7, 8, 9, 9, 9, 9);
        List<Integer> collect = lists.stream().filter(s -> s.equals(9)).collect(Collectors.toList());
        System.out.println(collect);
    }


}
