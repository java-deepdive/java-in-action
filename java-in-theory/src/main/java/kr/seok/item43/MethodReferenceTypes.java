package kr.seok.item43;

import java.time.Clock;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

public class MethodReferenceTypes<K, V> {
    // 메서드 참조 유형 - 정적 메서드
    public static int parseInt(String s) throws NumberFormatException { return 0; }

    // 메서드 참조 유형 - 한정적 (인스턴스)
    public static Instant now() {
        return Clock.systemUTC().instant();
    }
    // 함수 객체가 받는 인수와 참조되는 메서드가 받는 인수가 같음
    public boolean isAfter(Instant otherInstant) {
        return false;
    }

    // 메서드 참조 유형 - 비한정적 인스턴스
    public String toLowerCase(Locale locale) {
        // 함수 객체를 적용하는 시점에 수긴 객체를 알려준다.
        return "";
    }

    // 메서드 참조 유형 - 클래스 생성자
    Supplier<Object> treeMap = () -> new TreeMap<K, V>();

    // 메서드 참조 유형 - 배열 생성자
    public String[] methodReferenceConstructorArray() {
        List<String> numbers = Arrays.asList("1", "2");
        return numbers.toArray(new String[0]);
    }
}
