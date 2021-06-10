package com.example.behavioral.observer.message.domain;

public class Message {
    final String messageContent;

    public Message(String m) {
        this.messageContent = m;
    }

    public String getMessageContent() {
        return messageContent;
    }
}
