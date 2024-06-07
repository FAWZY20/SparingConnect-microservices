package com.gestioMessage.gestioMessage.controler;

import com.gestioMessage.gestioMessage.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class MessageControler {

    @MessageMapping("/chat")
    @SendTo("/message/{id}")
    public Message send(@RequestBody Message message) {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new Message(message.getRecipient_id(), message.getContent(), time);
    }

}
