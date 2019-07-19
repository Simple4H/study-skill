package com.simple4h.domain;

import lombok.Data;

/**
 * Create By Simple4H
 * Date: 2019-07-12 15:45
 */
@Data
public class KafkaMessageDto {

    private Long id;

    private String message;

    private Long sendTime;
}
