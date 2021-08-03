package kr.seok.item89;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Serializable 구현 및 readResolve 메서드를 구현한 클래스
 */
public class Elvis_3 implements Serializable {

    public static final Elvis_3 INSTANCE = new Elvis_3();
    private Elvis_3() {}

    private String[] favoriteSongs = {"Hound Dog", "Heartbreak Hotel"};
    public void printFavorites() {
        System.out.println(Arrays.toString(favoriteSongs));
    }

    // 기존의 인스턴스를 반환, 역직렬화한 객체는 무시
    private Object readResolve() {
        return INSTANCE;
    }
}
