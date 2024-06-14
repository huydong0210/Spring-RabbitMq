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
}
