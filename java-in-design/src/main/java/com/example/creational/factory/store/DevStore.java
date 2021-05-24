package com.example.creational.factory.store;

import com.example.creational.prototype.dev.BaseDeveloper;

public abstract class DevStore {

    public void develop() {

    }

    protected abstract BaseDeveloper create();
}
