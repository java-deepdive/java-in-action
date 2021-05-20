package kr.seok.item13.factory;

public class FactoryMethodCopyCoffee extends Coffee {

    public FactoryMethodCopyCoffee(Bean bean, Water water, Brand brand) {
        super(bean, water, brand);
    }

    public static FactoryMethodCopyCoffee newInstance(FactoryMethodCopyCoffee coffee) {
        return new FactoryMethodCopyCoffee(coffee.bean, coffee.water, coffee.brand);
    }
}
