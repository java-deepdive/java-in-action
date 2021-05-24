package com.example.structural.bridge.message.advanced;

public class EmailMessageSender implements MessageSender {
    @Override
    public void sendMessage() {
        System.out.println("Email");
    }
}
