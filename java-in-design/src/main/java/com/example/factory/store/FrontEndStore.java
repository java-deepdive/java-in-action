package com.example.factory.store;

import com.example.prototype.dev.BaseDeveloper;
import com.example.prototype.dev.concrete.FrontEnd;

public class FrontEndStore extends DevStore {

    @Override
    protected BaseDeveloper create() {
        return new FrontEnd();
    }
}
