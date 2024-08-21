package com.gestioMessage.gestioMessage.controler;

import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.RequestBody;

public interface MessageControler {


    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public void sendMessage(@RequestBody com.gestioMessage.gestioMessage.model.Message message);

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public Message addUser(com.gestioMessage.gestioMessage.model.Message message, SimpMessageHeaderAccessor headerAccessor);

}
