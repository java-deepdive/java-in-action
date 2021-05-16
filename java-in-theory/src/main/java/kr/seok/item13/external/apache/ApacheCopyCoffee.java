package kr.seok.item13.external.apache;

import java.io.Serializable;

public class ApacheCopyCoffee extends Coffee implements Serializable {

    public ApacheCopyCoffee(Bean bean, Water water, Brand brand) {
        super(bean, water, brand);
    }
}
