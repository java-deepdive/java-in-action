package kr.seok.item89;

public class Elvis_1 {
    /**
     * Elvis_1 인스턴스의 직렬화 형태는 아무런 실 데이터를 가질 이유가 없다. <br/>
     * 모든 인스턴스 필드를 transient로 선언해야 한다. <br/>
     * <p>
     * readResolve를 인스턴스 통제 목적으로 사용하는 경우 객체 참조 타입 인스턴스 필드는 <br/>
     * 모두 Transient로 선언해야 한다.
     */
    public static final Elvis_1 INSTANCE = new Elvis_1();

    private Elvis_1() {
    }

    public void leaveTheBuilding() {
    }
}
