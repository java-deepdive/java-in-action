package com.example.creational.prototype.dev.concrete;

import com.example.creational.prototype.dev.BaseDeveloper;
import com.example.creational.prototype.dev.DevType;

public class Client extends BaseDeveloper {

    public Client() {
        super(DevType.CLIENT);
    }

    @Override
    public Client clone() {
        return (Client) super.clone();
    }
}
