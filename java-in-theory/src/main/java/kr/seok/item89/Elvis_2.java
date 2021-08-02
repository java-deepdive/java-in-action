package kr.seok.item89;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Serializable 만 구현한 클래스
 */
public class Elvis_2 implements Serializable {

    public static final Elvis_2 INSTANCE = new Elvis_2();
    private String[] favoriteSongs = {"Hound Dog", "Heartbreak Hotel"};

    private Elvis_2() {
    }

    public void printFavorites() {
        System.out.println(Arrays.toString(favoriteSongs));
    }
}
