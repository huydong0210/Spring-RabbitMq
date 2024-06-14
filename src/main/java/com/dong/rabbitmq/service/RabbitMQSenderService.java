package com.dong.rabbitmq.service;

import com.dong.rabbitmq.config.RabbitMQProperties;
import com.dong.rabbitmq.config.RabbitMQSenderConfig;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;

public class RabbitMQSenderService extends RabbitMQSenderConfig {
    public RabbitMQSenderService(RabbitMQProperties rabbitMQProperties) {
        super(rabbitMQProperties);
    }
    public void send (String queueName, int priority, Object message){
        this.getAmqpTemplate().convertAndSend(
                queueName,
                message,
                new MessagePostProcessor() {
                    @Override
                    public Message postProcessMessage(Message message) throws AmqpException {
                        message.getMessageProperties().setPriority(priority);
                        return message;
                    }
                }
        );
    }
}

