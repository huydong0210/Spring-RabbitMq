package com.dong.rabbitmq.service;

import com.rabbitmq.client.Channel;
import java.nio.charset.StandardCharsets;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

@Component
public class MyListener implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        try {
            String jsonData = new String(message.getBody(), StandardCharsets.UTF_8);
            System.out.println("received message : " + jsonData);
        } catch (Exception var8) {
            throw var8;
        } finally {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        }
    }
}