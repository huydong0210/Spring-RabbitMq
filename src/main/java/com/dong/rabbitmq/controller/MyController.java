package com.dong.rabbitmq.controller;

import com.dong.rabbitmq.config.RabbitMQProperties;
import com.dong.rabbitmq.service.MySender;
import com.dong.rabbitmq.service.RabbitMQSenderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {
    private final RabbitMQSenderService senderService;
    private final RabbitMQProperties properties;

    public MyController(MySender mySender, RabbitMQProperties properties) {
        this.senderService = mySender;
        this.properties = properties;
    }
    @PostMapping("/message")
    public ResponseEntity<String> sendMessage(@RequestBody String message){
        this.senderService.send(properties.getQueue().getName(), 0, message);
        return ResponseEntity.ok("Send message successfully");
    }

}
