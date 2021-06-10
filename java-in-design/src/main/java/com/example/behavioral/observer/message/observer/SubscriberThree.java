package com.example.behavioral.observer.message.observer;

import com.example.behavioral.observer.message.domain.Message;

public class SubscriberThree implements Observer {
    @Override
    public void update(Message m) {
        System.out.println("MessageSubscriberThree :: " + m.getMessageContent());
    }
}
