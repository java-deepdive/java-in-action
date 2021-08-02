package kr.seok.item43;

import java.time.Clock;
import java.time.Instant;
import java.util.*;

public class MethodReferenceTypes<K, V> {
    // 메서드 참조 유형 - 클래스 생성자
    Supplier<Object> treeMap = () -> new TreeMap<K, V>();

    // 메서드 참조 유형 - 정적 메서드
    public static int parseInt(String s) throws NumberFormatException {
        return 0;
    }

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

    // 메서드 참조 유형 - 배열 생성자
    public String[] methodReferenceConstructorArray() {
        List<String> numbers = Arrays.asList("1", "2");
        return numbers.toArray(new String[0]);
    }

    static class DataContainer {
        private DataId id;
        private String data;
        public DataContainer(DataId id, String data) {
            this.id = id;
            this.data = data;
        }

        public DataId getId() {
            return id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DataContainer that = (DataContainer) o;
            return id == that.id && Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, data);
        }

        @Override
        public String toString() {
            return "DataContainer{" +
                    "id=" + id +
                    ", data='" + data + '\'' +
                    '}';
        }

        enum DataId {
            ID_1,
            ID_2,
            ID_3;
        }
    }
}
