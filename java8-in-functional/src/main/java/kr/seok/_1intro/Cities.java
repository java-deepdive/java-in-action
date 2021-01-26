package kr.seok._1intro;

import java.util.Arrays;
import java.util.List;

public class Cities {

    public static void findChicagoImperative(final List<String> cities) {

        boolean found = false;
        for(String city : cities) { // 반복
            if(city.equals("Chicago")) { // 포함되어 있는지 확인
                found = true;
                break;
            }
        }

        System.out.println("Found chicago : " + found);
    }

    public static void findChicagoDeclarative(final List<String> cities) {
        System.out.println("Found chicago : " + cities.contains("Chicago"));
    }

    public static void main(final String[] args) {
        List<String> cities =
                Arrays.asList("Albany", "Boulder", "Chicago", "Denver", "Eugene");

        findChicagoImperative(cities);
        findChicagoDeclarative(cities);
    }
}
