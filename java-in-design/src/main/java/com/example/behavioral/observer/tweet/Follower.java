package com.example.behavioral.observer.tweet;

public class Follower implements Observer {
    protected String name;

    public Follower(String name) {
        super();
        this.name = name;
    }

    @Override
    public void notification(String handle, String tweet) {
        System.out.printf("'%s' received notification from Handle: '%s', Tweet: '%s'\n", name, handle, tweet);
    }
}
