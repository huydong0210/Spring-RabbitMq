package com.dong.rabbitmq.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.ConditionalRejectingErrorHandler;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.support.ListenerExecutionFailedException;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

/**
 * Created by Huy Dong on 2/1/2024.
 * Author : Huy Dong
 */
public class RabbitMQListenerConfig implements RabbitListenerConfigurer {
    private RabbitMQProperties properties;

    private ConnectionFactory connectionFactory;
    private MessageListenerContainer MessageListenerContainer;

    public RabbitMQListenerConfig(RabbitMQProperties properties) {
        this.properties = properties;
        this.setConnectionFactory();
        this.setMessageListenerContainer();
    }

    public void setConnectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setVirtualHost(properties.getVirtualHost());
        connectionFactory.setHost(properties.getHost());
        connectionFactory.setUsername(properties.getUsername());
        connectionFactory.setPassword(properties.getPassword());
        this.connectionFactory = connectionFactory;
    }

    public DefaultMessageHandlerMethodFactory internalMessageHandlerMethodFactory() {
        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
        factory.setMessageConverter(new MappingJackson2MessageConverter());
        return factory;
    }
    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
        registrar.setMessageHandlerMethodFactory(this.internalMessageHandlerMethodFactory());
    }


    public MessageListenerContainer getMessageListenerContainer() {
        return MessageListenerContainer;
    }

    private void setMessageListenerContainer() {
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
        simpleMessageListenerContainer.setQueueNames(properties.getQueue().getName());
        simpleMessageListenerContainer.setConcurrentConsumers(properties.getConcurrentConsumers());
        simpleMessageListenerContainer.setMaxConcurrentConsumers(properties.getMaxConcurrentConsumers());
        simpleMessageListenerContainer.setPrefetchCount(properties.getPrefetch());
        simpleMessageListenerContainer.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        simpleMessageListenerContainer.setErrorHandler(new ConditionalRejectingErrorHandler(new MyFatalExceptionStrategy()));
//        simpleMessageListenerContainer.setMessageListener(this.channelAwareMessageListener);
        MessageListenerContainer = simpleMessageListenerContainer;
    }

    public static class MyFatalExceptionStrategy extends ConditionalRejectingErrorHandler.DefaultExceptionStrategy {

        private final Logger logger = LogManager.getLogger(getClass());

        @Override
        public boolean isFatal(Throwable t) {
            if (t instanceof ListenerExecutionFailedException) {
                ListenerExecutionFailedException lefe = (ListenerExecutionFailedException) t;
                logger.error(
                        "Failed to process inbound message from queue " +
                                lefe.getFailedMessage().getMessageProperties().getConsumerQueue() +
                                "; failed message: " +
                                lefe.getFailedMessage(),
                        t
                );
            }
            return super.isFatal(t);
        }
    }

}
