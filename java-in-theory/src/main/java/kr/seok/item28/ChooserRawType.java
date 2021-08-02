package kr.seok.item28;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ChooserRawType {

    private final Object[] choiceArray;

    public ChooserRawType(Object[] choiceArray) {
        this.choiceArray = choiceArray;
    }

    /**
     * 해당 메서드 호출 시 반환된 Object를 원하는 타입으로 형변환 필요
     *
     * @throws 혹시나 타입이 다른 원소가 들어있었다면 런타임에 형변환 오류가 발생
     */
    public Object choose() { // 해당 메서드 호출 시 반환된 Object를 원하는 타입으로 형변환 필요
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }
}
