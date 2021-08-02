package com.example.behavioral.observer.message.publisher;

import com.example.behavioral.observer.message.domain.Message;
import com.example.behavioral.observer.message.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Publisher implements Subject {

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyUpdate(Message m) {
        for (Observer o : observers) {
            o.update(m);
        }
    }
}
