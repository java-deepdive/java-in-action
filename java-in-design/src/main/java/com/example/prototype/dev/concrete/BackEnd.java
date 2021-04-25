package com.example.prototype.dev.concrete;

import com.example.prototype.dev.BaseDeveloper;
import com.example.prototype.dev.DevType;

public class BackEnd extends BaseDeveloper {

    public BackEnd() {
        super(DevType.BACKEND);
    }

    @Override
    public BackEnd clone() {
        return (BackEnd) super.clone();
    }
}
