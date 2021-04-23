package com.example.prototype.study.concrete;

import com.example.prototype.study.BaseDeveloper;
import com.example.prototype.study.DevType;

public class BackEnd extends BaseDeveloper {

    public BackEnd() {
        super(DevType.BACKEND);
    }

    @Override
    public BackEnd clone() {
        BackEnd clone = null;
        try {
            clone = (BackEnd) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
