package com.example.behavioral.iterators.iterator;

import com.example.behavioral.iterators.profile.Profile;

public interface ProfileIterator {
    boolean hasNext();

    Profile getNext();

    void reset();
}
