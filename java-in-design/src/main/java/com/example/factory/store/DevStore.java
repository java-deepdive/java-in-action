package com.example.factory.store;

import com.example.prototype.dev.BaseDeveloper;

public abstract class DevStore {

    public void develop() {

    }

    protected abstract BaseDeveloper create();
}
