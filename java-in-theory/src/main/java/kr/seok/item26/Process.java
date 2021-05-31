package kr.seok.item26;

import java.util.ArrayList;
import java.util.Collection;

public class Process {
    private final Collection<Stamp> stamps;

    public Process() {
        this.stamps = new ArrayList<>();
    }

    public void add() {
        //stamps.add(new Coin());
    }
    public static void main(String[] args) {
        new Process();
    }
}
