package com.example.behavioral.observer.message.publisher;

import com.example.behavioral.observer.message.domain.Message;
import com.example.behavioral.observer.message.observer.Observer;

public interface Subject {
    void attach(Observer observer);

    void detach(Observer observer);

    void notifyUpdate(Message msg);
}
