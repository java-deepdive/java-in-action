package kr.seok.item13.immutable;

import kr.seok.item13.Bean;

import java.util.Objects;

public class Coffee implements Cloneable {

    private final Bean bean;

    public Coffee(Bean bean) {
        this.bean = bean;
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
    public synchronized Coffee clone() {
        Coffee clone;
        try {
            clone = (Coffee) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
        return clone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coffee)) return false;
        final Coffee coffee = (Coffee) o;
        return Objects.equals(bean, coffee.bean);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bean);
    }
}
