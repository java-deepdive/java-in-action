package com.example.behavioral.observer.message;

import com.example.behavioral.observer.message.domain.Message;
import com.example.behavioral.observer.message.observer.SubscriberOne;
import com.example.behavioral.observer.message.observer.SubscriberThree;
import com.example.behavioral.observer.message.observer.SubscriberTwo;
import com.example.behavioral.observer.message.publisher.Publisher;

public class Demo {

    public static void main(String[] args) {
        SubscriberOne s1 = new SubscriberOne();
        SubscriberTwo s2 = new SubscriberTwo();
        SubscriberThree s3 = new SubscriberThree();

        Publisher p = new Publisher();

        p.attach(s1);
        p.attach(s2);

        p.notifyUpdate(new Message("First Message"));   //s1 and s2 will receive the update

        p.detach(s1);
        p.attach(s3);

        p.notifyUpdate(new Message("Second Message")); //s2 and s3 will receive the update
    }
}
