package com.salud.salud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class NotificationController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/send-notification")
    @SendTo("/topic/notifications")
    public String SendNotification(String message){
        return message;
    }

    public void sendCustomNotification(String message){
        messagingTemplate.convertAndSend("/topic/notifications", message);
    }
}
