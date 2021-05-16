package kr.seok.item13.constructor;

public class ConstructorCopyCoffee extends Coffee {

    public ConstructorCopyCoffee(Bean bean, Water water, Brand brand) {
        super(bean, water, brand);
    }

    // 복사 생성자를 통한 복사
    public ConstructorCopyCoffee(ConstructorCopyCoffee deepCopy) {
        super(deepCopy.bean, deepCopy.water, deepCopy.brand);
    }
}
