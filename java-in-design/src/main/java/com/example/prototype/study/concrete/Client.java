package com.example.prototype.study.concrete;

import com.example.prototype.study.BaseDeveloper;
import com.example.prototype.study.DevType;

public class Client extends BaseDeveloper {

    public Client() {
        super(DevType.CLIENT);
    }

    @Override
    public Client clone() {
        Client clone = null;
        try {
            clone = (Client) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
