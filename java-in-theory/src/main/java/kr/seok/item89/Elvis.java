package kr.seok.item89;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Serializable 구현 및 readResolve 메서드를 구현한 클래스
 */
public class Elvis implements Serializable {
    public static final Elvis INSTANCE = new Elvis();
    private Elvis() {
    }

    private String[] favoriteSongs = { "Hound Dog", "Heartbreak Hotel" };
    public void printFavorites() {
        System.out.println(Arrays.toString(favoriteSongs));
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
