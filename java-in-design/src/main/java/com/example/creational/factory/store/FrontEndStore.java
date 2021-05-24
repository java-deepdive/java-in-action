package com.example.creational.factory.store;

import com.example.creational.prototype.dev.BaseDeveloper;
import com.example.creational.prototype.dev.concrete.FrontEnd;

public class FrontEndStore extends DevStore {

    @Override
    protected BaseDeveloper create() {
        return new FrontEnd();
    }
}
