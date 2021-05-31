package kr.seok.item28;

import java.util.Collection;

public class ChooserClassTypeGeneric<T> {
    private final T[] choiceArray;

    public ChooserClassTypeGeneric(Collection<T> choiceArray) {
        // 컴파일 오류
        // this.choiceArray = choiceArray.toArray();
        // 경고: 컴파일러는 이 형변환이 런타임에도 안전한지 보장할 수 없음
        this.choiceArray = (T[]) choiceArray.toArray();
    }
}
