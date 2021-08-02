package kr.seok.item28;

import java.util.ArrayList;
import java.util.List;

public class Item28 {

    public static void main(String[] args) {
//        List<String>[] stringsLists = new List<String>[1];
//        List<Integer> intList = List.of(42);
//        Object[] objects = stringsLists;
//        objects[0] = intList;
//        String s = stringsLists[0].get(0);


        List<?>[] lists = new List<?>[1];

        Object obj = new Object();
        Object[] objArr = new String[2];
        Object[] objLong = new Long[1];
        System.out.println(Constants.data);
    }

    public void arr() {
        ArrayList<String> items = new ArrayList<>();
        items.add("data");
    }
}
