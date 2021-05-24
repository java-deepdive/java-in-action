package com.example.structural.bridge.message.advanced;

public class EmailMessage extends Message {
    public EmailMessage(MessageSender messageSender) {
        super(messageSender);
    }

    @Override
    public void send() {
        messageSender.sendMessage();
    }
}
