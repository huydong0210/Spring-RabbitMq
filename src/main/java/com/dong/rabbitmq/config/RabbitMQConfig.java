package com.dong.rabbitmq.config;
import com.dong.rabbitmq.service.MyListener;
import com.dong.rabbitmq.service.MySender;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class RabbitMQConfig {

    private final MyListener myListener;
    private final RabbitMQProperties rabbitMQProperties;

    public RabbitMQConfig(MyListener ebRabbitListener, RabbitMQProperties rabbitMQProperties) {
        this.rabbitMQProperties = rabbitMQProperties;
        this.myListener = ebRabbitListener;
    }

    @Bean
    public MySender rabbitSender() {
        return new MySender(this.rabbitMQProperties);
    }

    @Bean
    public RabbitMQListenerConfig rabbitMQListenerConfig() {
        return new RabbitMQListenerConfig(this.rabbitMQProperties);
    }

    @Bean
    public MessageListenerContainer messageListenerContainer() {
        SimpleMessageListenerContainer simpleMessageListenerContainer = (SimpleMessageListenerContainer) this.rabbitMQListenerConfig()
            .getMessageListenerContainer();
        simpleMessageListenerContainer.setMessageListener(myListener);
        return simpleMessageListenerContainer;
    }
}
