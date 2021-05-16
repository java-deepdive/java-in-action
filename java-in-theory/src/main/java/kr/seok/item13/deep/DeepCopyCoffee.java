package kr.seok.item13.deep;


public class DeepCopyCoffee extends Coffee implements Cloneable {

    public DeepCopyCoffee(Bean bean, Water water, Brand brand) {
        super(bean, water, brand);
    }

    /**
     * 불변 객체의 clone 퍼블릭 인터페이스 제공 <br/>
     *  1. Cloneable 인터페이스 구현 <br/>
     *  2. clone() 메서드 재정의 <br/>
     *  3. 접근제한자 수정 protected -> public <br/>
     *  4. 반환 타입 수정 Object -> Coffee <br/>
     *  5. throws 제거 내부적으로 예외 처리 <br/>
     *  - 쓸데 없는 복사를 지양한다는 관점에서 불변 객체는 굳이 clone 메서드를 제공하지 않는 것이 좋다. <br/>
     */
    @Override
    public synchronized DeepCopyCoffee clone() {
        DeepCopyCoffee clone;
        try {
            clone = (DeepCopyCoffee) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
        return clone;
    }
}
