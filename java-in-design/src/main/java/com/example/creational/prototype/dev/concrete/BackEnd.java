package com.example.creational.prototype.dev.concrete;

import com.example.creational.prototype.dev.BaseDeveloper;
import com.example.creational.prototype.dev.DevType;

public class BackEnd extends BaseDeveloper {

    public BackEnd() {
        super(DevType.BACKEND);
    }

    @Override
    public BackEnd clone() {
        return (BackEnd) super.clone();
    }
}
