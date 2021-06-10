package com.example.behavioral.observer.message.observer;

import com.example.behavioral.observer.message.domain.Message;

public class SubscriberOne implements Observer
{
    @Override
    public void update(Message m) {
        System.out.println("MessageSubscriberOne :: " + m.getMessageContent());
    }
}
