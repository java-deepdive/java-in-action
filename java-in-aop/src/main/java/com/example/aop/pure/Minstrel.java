package com.example.aop.pure;

import java.io.PrintStream;

public class Minstrel {

    private final PrintStream stream;

    public Minstrel(PrintStream stream) {
        this.stream = stream;
    }

    public void singBeforeQuest() {
        stream.println("퀘스트 전 노래 부르기");
    }

    public void singAfterQuest() {
        stream.println("퀘스트 후 노래 부르기");
    }
}
