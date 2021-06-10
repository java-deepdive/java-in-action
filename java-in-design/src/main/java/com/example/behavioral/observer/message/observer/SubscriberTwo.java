package com.example.behavioral.observer.message.observer;

import com.example.behavioral.observer.message.domain.Message;

public class SubscriberTwo implements Observer {
    @Override
    public void update(Message m) {
        System.out.println("MessageSubscriberTwo :: " + m.getMessageContent());
    }
}
