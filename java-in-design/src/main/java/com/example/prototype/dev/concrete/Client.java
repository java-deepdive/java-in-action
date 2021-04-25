package com.example.prototype.dev.concrete;

import com.example.prototype.dev.BaseDeveloper;
import com.example.prototype.dev.DevType;

public class Client extends BaseDeveloper {

    public Client() {
        super(DevType.CLIENT);
    }

    @Override
    public Client clone() {
        return (Client) super.clone();
    }
}
