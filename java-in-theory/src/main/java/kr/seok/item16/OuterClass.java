package kr.seok.item16;

public class OuterClass {

    private InnerClass innerClass;

    public OuterClass() {
        this.innerClass = new InnerClass();
    }

    // 내부 클래스의 수정 기능을 제공하기 위한 퍼블릭 인터페이스
    public void changeValue(int value) {
        innerClass.value = value;
    }

    // 접근자(getter)
    public int value() {
        return innerClass.value;
    }

    // 내부 클래스
    class InnerClass {
        public int value;
    }
}
