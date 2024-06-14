package com.dong.rabbitmq.config;


import org.springframework.amqp.core.Queue;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "rabbitmq")
public class RabbitMQProperties {

    private Queue queue;
    private String host;
    private String virtualHost;
    private String username;
    private String password;
    private String exchange;
    private String routingKey;
    private Integer replyTimeOut;
    private Integer concurrentConsumers;
    private Integer maxConcurrentConsumers;
    private Integer prefetch;

//    public RabbitMQProperties(Builder builder) {
//        this.queue = builder.defaultReceiveQueue;
//        this.host = builder.host;
//        this.virtualHost = builder.virtualHost;
//        this.username = builder.username;
//        this.password = builder.password;
//        this.exchange = builder.exchange;
//        this.routingKey = builder.routingKey;
//        this.replyTimeOut = builder.replyTimeOut;
//        this.concurrentConsumers = builder.concurrentConsumers;
//        this.maxConcurrentConsumers = builder.maxConcurrentConsumers;
//        this.prefetch = builder.prefetch;
//    }

    public Queue getQueue() {
        return queue;
    }

    public String getHost() {
        return host;
    }

    public String getVirtualHost() {
        return virtualHost;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getExchange() {
        return exchange;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public Integer getReplyTimeOut() {
        return replyTimeOut;
    }

    public Integer getConcurrentConsumers() {
        return concurrentConsumers;
    }

    public Integer getMaxConcurrentConsumers() {
        return maxConcurrentConsumers;
    }

    public Integer getPrefetch() {
        return prefetch;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setVirtualHost(String virtualHost) {
        this.virtualHost = virtualHost;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public void setReplyTimeOut(Integer replyTimeOut) {
        this.replyTimeOut = replyTimeOut;
    }

    public void setConcurrentConsumers(Integer concurrentConsumers) {
        this.concurrentConsumers = concurrentConsumers;
    }

    public void setMaxConcurrentConsumers(Integer maxConcurrentConsumers) {
        this.maxConcurrentConsumers = maxConcurrentConsumers;
    }

    public void setPrefetch(Integer prefetch) {
        this.prefetch = prefetch;
    }

//    public static class Builder {
//
//        private String host;
//        private String virtualHost;
//        private String username;
//        private String password;
//        private String exchange;
//        private String routingKey;
//        private Queue defaultReceiveQueue;
//        private Integer replyTimeOut;
//        private Integer concurrentConsumers;
//        private Integer maxConcurrentConsumers;
//        private Integer prefetch;
//
//
//        public Builder host(String host) {
//            this.host = host;
//            return this;
//        }
//
//        public Builder virtualHost(String virtualHost) {
//            this.virtualHost = virtualHost;
//            return this;
//        }
//
//        public Builder username(String username) {
//            this.username = username;
//            return this;
//        }
//
//        public Builder password(String password) {
//            this.password = password;
//            return this;
//        }
//
//        public Builder exchange(String exchange) {
//            this.exchange = exchange;
//            return this;
//        }
//
//        public Builder routingKey(String routingKey) {
//            this.routingKey = routingKey;
//            return this;
//        }
//
//        public Builder defaultReceiveQueue(String defaultReceiveQueue) {
//            this.defaultReceiveQueue = new Queue(defaultReceiveQueue, true);
//            return this;
//        }
//
//        public Builder concurrentConsumers(Integer concurrentConsumers) {
//            this.concurrentConsumers = concurrentConsumers;
//            return this;
//        }
//
//        public Builder maxConcurrentConsumers(Integer maxConcurrentConsumers) {
//            this.maxConcurrentConsumers = maxConcurrentConsumers;
//            return this;
//        }
//
//        public Builder replyTimeout(Integer replyTimeOut) {
//            this.replyTimeOut = replyTimeOut;
//            return this;
//        }
//        public Builder prefetch(Integer prefetch){
//            this.prefetch =prefetch;
//            return this;
//        }
//
//        public RabbitMQProperties build() {
//            return new RabbitMQProperties(this);
//        }
//
//    }
}
