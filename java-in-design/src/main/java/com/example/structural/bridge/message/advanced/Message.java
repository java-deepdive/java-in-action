package com.example.structural.bridge.message.advanced;

public abstract class Message {
    protected final MessageSender messageSender;

    protected Message(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    protected abstract void send();
}
