package com.example.creational.factory.store;

import com.example.creational.prototype.dev.BaseDeveloper;
import com.example.creational.prototype.dev.concrete.BackEnd;

public class BackEndStore extends DevStore {

    @Override
    public BaseDeveloper create() {
        return new BackEnd();
    }
}
