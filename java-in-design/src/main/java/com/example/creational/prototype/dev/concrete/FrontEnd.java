package com.example.creational.prototype.dev.concrete;

import com.example.creational.prototype.dev.BaseDeveloper;
import com.example.creational.prototype.dev.DevType;

public class FrontEnd extends BaseDeveloper {

    public FrontEnd() {
        super(DevType.FRONTEND);
    }

    @Override
    public FrontEnd clone() {
        return (FrontEnd) super.clone();
    }
}
