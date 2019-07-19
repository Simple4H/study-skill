package com.simple4h.kafka;

import com.google.gson.Gson;
import com.simple4h.domain.KafkaMessageDto;
import com.simple4h.domain.MqDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * Create By Simple4H
 * Date: 2019-07-12 16:45
 */
@Service
@Slf4j
public class kafka {

    @Autowired
    private Gson gson;

    @KafkaListener(topics = "abc123")
    private String listen(@Payload String message) {
        log.info("get a mq");
        KafkaMessageDto kafkaMessageDto = gson.fromJson(message, KafkaMessageDto.class);
        MqDto mqDto = gson.fromJson(kafkaMessageDto.getMessage(), MqDto.class);
        log.warn("username:{},password:{}", mqDto.getUsername(), mqDto.getPassword());
        return message;
    }
}
