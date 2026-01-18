package com.chatapp.mychatingapp.controller;

import com.chatapp.mychatingapp.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage")
    @SendTo("/topic/message")
    public ChatMessage sendMessage(ChatMessage message){
        System.out.println("Sender: " + message.getSender());
        System.out.println("Content: " + message.getContent());
        return message;
    }

    @GetMapping("/chat")
    public String chat(){
        return "chat";
    }
}
