package com.example.factory.store;

import com.example.prototype.dev.BaseDeveloper;
import com.example.prototype.dev.concrete.Client;

public class ClientStore extends DevStore {

    @Override
    protected BaseDeveloper create() {
        return new Client();
    }
}
