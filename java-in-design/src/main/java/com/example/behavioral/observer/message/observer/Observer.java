package com.example.behavioral.observer.message.observer;

import com.example.behavioral.observer.message.domain.Message;

public interface Observer {
    void update(Message m);
}
