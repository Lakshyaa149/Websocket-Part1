package com.pubsub.redispubsub.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.ReactiveSubscription;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;

@Service
public class RedisService {


    @Autowired
    private ReactiveRedisTemplate<String,String> reactiveRedisTemplate;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    public void publish(String topic,String message){
        System.out.println("Message received"+message);
        reactiveRedisTemplate.convertAndSend(topic,message).subscribe();
    }

    public void subscribe(String channelTopic,String destination){

        reactiveRedisTemplate.listenTo(ChannelTopic.of(channelTopic)).map(
                ReactiveSubscription.Message<String,String>::getMessage).subscribe(message->simpMessagingTemplate.convertAndSend(destination,message));
    }


    @PostConstruct
    public void subscribe(){
        subscribe("GREETING_CHANNEL_INBOUND","/topic/greetings");
    }


}
