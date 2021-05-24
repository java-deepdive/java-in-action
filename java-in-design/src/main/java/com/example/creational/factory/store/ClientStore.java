package com.example.creational.factory.store;

import com.example.creational.prototype.dev.BaseDeveloper;
import com.example.creational.prototype.dev.concrete.Client;

public class ClientStore extends DevStore {

    @Override
    protected BaseDeveloper create() {
        return new Client();
    }
}
