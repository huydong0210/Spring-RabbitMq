package com.dong.rabbitmq.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;

public class RabbitMQSenderConfig {
    private RabbitMQProperties properties;
    private ConnectionFactory connectionFactory;
    private AmqpTemplate amqpTemplate;

    public RabbitMQSenderConfig(RabbitMQProperties rabbitMQProperties) {
        this.properties = rabbitMQProperties;
        this.setConnectionFactory();
        this.setAmqpTemplate();
    }

    public void setConnectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setVirtualHost(properties.getVirtualHost());
        connectionFactory.setHost(properties.getHost());
        connectionFactory.setUsername(properties.getUsername());
        connectionFactory.setPassword(properties.getPassword());
        this.connectionFactory = connectionFactory;
    }

    public AmqpTemplate getAmqpTemplate() {
        return amqpTemplate;
    }

    public void setAmqpTemplate() {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setDefaultReceiveQueue(properties.getQueue().getName());
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter(new ObjectMapper()));
        rabbitTemplate.setReplyAddress(properties.getQueue().getName());
        rabbitTemplate.setReplyTimeout(properties.getReplyTimeOut());
        rabbitTemplate.setUseDirectReplyToContainer(false);
        amqpTemplate = rabbitTemplate;
    }
}
