package kr.seok.java8.chap2;

/**
 * 함수형 인터페이스의 추상 메서드 Signature 는 람다 표현식의 Signature 를 가리킨다. <br/>
 *
 * 람다 표현식의 시그니처를 서술하는 메서드를 함수 디스크립터(functional descriptor)라고 부른다.
 *
 */
public class FunctionalDescriptor {

    public static void processor(Runnable r) {
        r.run();
    }
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        /*
            인수가 없으며 void 를 반환하는 람다 표현식
            Runnable 인터페이스의 run 메서드 시그니처와 같음
         */
        processor(() -> System.out.println("This is awesome!!"));
    }
}
