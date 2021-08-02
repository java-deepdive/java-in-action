package com.example.behavioral.observer;

import com.example.behavioral.observer.channel.NewsAgency;
import com.example.behavioral.observer.channel.NewsChannel;
import com.example.behavioral.observer.listener.PCLNewsAgency;
import com.example.behavioral.observer.listener.PCLNewsChannel;
import com.example.behavioral.observer.observers.ONewsAgency;
import com.example.behavioral.observer.observers.ONewsChannel;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ChannelTest {

    @Test
    void whenChangingNewsAgencyState_thenNewsChannelNotified() {

        NewsAgency observable = new NewsAgency();
        NewsChannel observer = new NewsChannel();

        observable.addObserver(observer);

        observable.setNews("news");
        assertThat(observer.getNews()).isEqualTo("news");
    }

    @Test
    void whenChangingONewsAgencyState_thenONewsChannelNotified() {

        ONewsAgency observable = new ONewsAgency();
        ONewsChannel observer = new ONewsChannel();

        observable.addObserver(observer);

        observable.setNews("news");
        assertEquals(observer.getNews(), "news");
    }

    @Test
    void whenChangingPCLNewsAgencyState_thenONewsChannelNotified() {

        PCLNewsAgency observable = new PCLNewsAgency();
        PCLNewsChannel observer = new PCLNewsChannel();

        observable.addPropertyChangeListener(observer);

        observable.setNews("news");
        assertEquals(observer.getNews(), "news");
    }

}
