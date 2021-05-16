package kr.seok.item13.mutable;

import kr.seok.item13.Bean;

import java.util.Objects;

public class Coffee implements Cloneable {

    private Bean bean;

    public Coffee(Bean bean) {
        this.bean = bean;
    }

    public void setBean(Bean bean) {
        this.bean = bean;
    }

    /**
     * Mutable 클래스에서 clone을 구현하는 방법 <br/>
     *  1. <strong> clone()를 재정의 </strong> <br/>
     *      - Cloneable 인터페이스를 구현하는 클래스는 clone() 메서드를 모두 재정의 해준다. <br/>
     *  2. <strong> 접근 제한자의 수정 </strong> <br/>
     *      - 외부에서 사용할 수 있도록 접근제한자를 수정 protected -> public  <br/>
     *  3. <strong> 반환 타입의 수정 </strong> <br/>
     *      - Object -> Coffee 인터페이스를 사용하는 클래스에서 편하게 사용할 수 있도록 리턴 타입을 수정 <br/>
     *  4. <strong> 동기화 처리 </strong> <br/>
     *      - 스레드 안전 클래스를 작성할 때는 synchronized 로 동기화 처리 <br/>
     *  5. <strong> throws를 제거 </strong> <br/>
     *      - throws 를 제거하고 내부적으로 try - catch 처리 하여 메서드 사용 편의성을 제공한다. <br/>
     *  6. <strong> mutable 한 객체를 복사</strong> <br/>
     *      - 복제본이 가진 개체 참조를 모두가 복사된 객체들을 가리키도록 하기 위함
     */
    @Override
    public synchronized Coffee clone() {
        Coffee clone;
        try {
            clone = (Coffee) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
        clone.bean = (bean.clone() != null) ? bean.clone() : null;
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

    @Override
    public String toString() {
        return "Coffee{" +
                "bean=" + bean +
                '}';
    }
}
