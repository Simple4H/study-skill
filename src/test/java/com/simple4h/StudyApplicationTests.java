package com.simple4h;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class StudyApplicationTests {

    @Autowired
    private StringRedisTemplate redisTemplate;

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

    @Test
    public void redisSet() {
        List<Integer> canSendOrderIds = Lists.newArrayList(1, 2, 3, 4, 5);
        for (Integer canSendOrderId : canSendOrderIds) {
            redisTemplate.executePipelined((RedisCallback<Object>) connection -> {
                StringRedisConnection stringRedisConn = (StringRedisConnection) connection;
                stringRedisConn.sAdd("WEIXIN_TEMPLATE_MSG_SUB_JOB", canSendOrderId.toString());
                redisTemplate.expire("WEIXIN_TEMPLATE_MSG_SUB_JOB", 2, TimeUnit.HOURS);
                return null;
            });

        }
    }

    @Test
    public void redisGet() {
        Set<String> set = redisTemplate.opsForSet().members("WEIXIN_TEMPLATE_MSG_SUB_JOB");

        log.error("set:{}", set);
    }


}
