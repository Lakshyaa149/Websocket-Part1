package com.pubsub.redispubsub.controller;


import com.pubsub.redispubsub.model.NewMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class NotificationController {

    @Autowired
    private  SimpMessagingTemplate simpMessagingTemplate;


    @PostMapping(value = "/api/notification")
    public ResponseEntity newMessage(@RequestBody NewMessageRequest request){
        simpMessagingTemplate.convertAndSend(request.getTopic(),request.getMessage());

         return ResponseEntity.ok(HttpStatus.OK);
    }








}
