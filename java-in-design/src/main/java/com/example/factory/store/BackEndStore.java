package com.example.factory.store;

import com.example.prototype.dev.BaseDeveloper;
import com.example.prototype.dev.concrete.BackEnd;

public class BackEndStore extends DevStore {

    @Override
    public BaseDeveloper create() {
        return new BackEnd();
    }
}
