package com.gestioMessage.gestioMessage.model;

import jakarta.persistence.*;

@Entity
@Table(name = "message")
public class Message {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "vehicle_seq", allocationSize = 1)
    private Long id;

    @Column(name = "conversation_id")
    private Long conversation_id;

    @Column(name = "sender_id")
    private Long sender_id;

    @Column(name = "recipient_id ")
    private Long recipient_id;

    @Column(name = "content")
    private String content;

    @Column(name = "timestamp")
    private String timestamp;

    @Column(name = "status")
    private Enum status;

    @Column(name = "deleted")
    private Boolean deleted;

    public Message(Long id, Long conversation_id, Long sender_id, Long recipient_id, String content, String timestamp, Enum status, Boolean deleted) {
        this.id = id;
        this.conversation_id = conversation_id;
        this.sender_id = sender_id;
        this.recipient_id = recipient_id;
        this.content = content;
        this.timestamp = timestamp;
        this.status = status;
        this.deleted = deleted;
    }

    public Message(Long recipient_id, String content, String timestamp) {
        this.recipient_id = recipient_id;
        this.content = content;
        this.timestamp = timestamp;
    }

    public Message(){

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getConversation_id() {
        return conversation_id;
    }

    public void setConversation_id(Long conversation_id) {
        this.conversation_id = conversation_id;
    }

    public Long getSender_id() {
        return sender_id;
    }

    public void setSender_id(Long sender_id) {
        this.sender_id = sender_id;
    }

    public Long getRecipient_id() {
        return recipient_id;
    }

    public void setRecipient_id(Long recipient_id) {
        this.recipient_id = recipient_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }


}
