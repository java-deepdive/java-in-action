package com.example.domain;

import com.example.afactory.component.Bean;
import com.example.afactory.component.Water;

import java.io.Serializable;

public class ApacheCopyCoffee extends Coffee implements Serializable {

    public ApacheCopyCoffee(Bean bean, Water water, Brand brand) {
        super(bean, water, brand);
    }
}
