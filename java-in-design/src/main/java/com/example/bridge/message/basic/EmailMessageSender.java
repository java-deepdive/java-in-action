package com.example.bridge.message.basic;

public class EmailMessageSender extends EmailMessage {
    @Override
    protected void send() {
        System.out.println("Email Sender");
    }
}
