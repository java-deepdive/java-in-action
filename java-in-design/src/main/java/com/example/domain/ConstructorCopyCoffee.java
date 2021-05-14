package com.example.domain;

import com.example.afactory.component.Bean;
import com.example.afactory.component.Water;

public class ConstructorCopyCoffee extends Coffee {

    protected ConstructorCopyCoffee(Bean bean, Water water, Brand brand) {
        super(bean, water, brand);
    }

    // 복사 생성자를 통한 복사
    public ConstructorCopyCoffee(ConstructorCopyCoffee deepCopy) {
        super(deepCopy.bean, deepCopy.water, deepCopy.brand);
    }
}
