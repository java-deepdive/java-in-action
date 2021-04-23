package com.example.prototype.study.concrete;

import com.example.prototype.study.BaseDeveloper;
import com.example.prototype.study.DevType;

public class FrontEnd extends BaseDeveloper {

    public FrontEnd() {
        super(DevType.FRONTEND);
    }

    @Override
    public FrontEnd clone() {
        FrontEnd clone = null;
        try {
            clone = (FrontEnd) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
