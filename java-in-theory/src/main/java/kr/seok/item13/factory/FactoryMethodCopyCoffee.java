package kr.seok.item13.factory;

public class FactoryMethodCopyCoffee extends Coffee {

    public FactoryMethodCopyCoffee(Bean bean, Water water, Brand brand) {
        super(bean, water, brand);
    }

    // 복사 생성자를 통한 복사
    public FactoryMethodCopyCoffee(FactoryMethodCopyCoffee deepCopy) {
        super(deepCopy.bean, deepCopy.water, deepCopy.brand);
    }

    public static FactoryMethodCopyCoffee newInstance(FactoryMethodCopyCoffee coffee) {
        return new FactoryMethodCopyCoffee(coffee.bean, coffee.water, coffee.brand);
    }
}
