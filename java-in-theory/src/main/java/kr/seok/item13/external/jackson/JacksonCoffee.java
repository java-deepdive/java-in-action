package kr.seok.item13.external.jackson;

public class JacksonCoffee extends Coffee {

    private JacksonCoffee() { this(null, null, null); }

    protected JacksonCoffee(Bean bean, Water water, Brand brand) {
        super(bean, water, brand);
    }

    @Override
    public String toString() {
        return "JacksonCoffee{" +
                "bean=" + bean +
                ", water=" + water +
                ", brand=" + brand +
                '}';
    }
}
