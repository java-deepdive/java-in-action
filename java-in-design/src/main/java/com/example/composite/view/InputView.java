package com.example.composite.view;

import com.example.composite.order.MenuItem;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner in = new Scanner(System.in);

    public static MenuItem inputMenu(List<MenuItem> all) {
        all.forEach(System.out::println);
        return MenuItem.find(in.nextLine());
    }
}
