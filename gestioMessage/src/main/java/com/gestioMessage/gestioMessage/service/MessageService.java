package com.gestioMessage.gestioMessage.service;

import com.gestioMessage.gestioMessage.controler.MessageControler;
import com.gestioMessage.gestioMessage.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageService implements MessageControler {

    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    MessageRepository messageRepository;

    public MessageService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @Override
    public void sendMessage(com.gestioMessage.gestioMessage.model.Message message) {
        messageRepository.save(message);
        messagingTemplate.convertAndSendToUser(String.valueOf(message.getRecipient_id()), "/queue/messages", message);
    }

    @Override
    public Message addUser(com.gestioMessage.gestioMessage.model.Message message, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", message.getSender_id());
        return (Message) message;
    }
}
