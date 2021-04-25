package com.example.prototype.dev.concrete;

import com.example.prototype.dev.BaseDeveloper;
import com.example.prototype.dev.DevType;

public class FrontEnd extends BaseDeveloper {

    public FrontEnd() {
        super(DevType.FRONTEND);
    }

    @Override
    public FrontEnd clone() {
        return (FrontEnd) super.clone();
    }
}
