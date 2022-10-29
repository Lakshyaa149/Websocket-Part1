package com.pubsub.redispubsub.controller;

import com.pubsub.redispubsub.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class WebSocketController {

    @Autowired
    private RedisService redisService;

    @MessageMapping("/greet")
    public void greetMessage(@Payload String message){

        redisService.publish("GREETING_CHANNEL_INBOUND",message);

    }
}
