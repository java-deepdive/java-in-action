package com.example.behavioral.observer.tweet;

public interface Subject {
    void addSubscriber(Observer observer);

    void removeSubscriber(Observer observer);

    void notifySubscribers(String tweet);
}
