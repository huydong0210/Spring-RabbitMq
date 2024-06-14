package com.dong.rabbitmq.service;

import com.dong.rabbitmq.config.RabbitMQProperties;

public class MySender extends RabbitMQSenderService {

    public MySender(RabbitMQProperties rabbitMQProperties) {
        super(rabbitMQProperties);
    }

}

