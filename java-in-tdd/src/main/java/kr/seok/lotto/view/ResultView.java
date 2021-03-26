package kr.seok.lotto.view;

import java.io.PrintStream;

public class ResultView {
    private final PrintStream printStream;

    public ResultView() {
        this.printStream = new PrintStream(System.out);
    }

    public void print(String message) {
        printStream.println(message);
    }

    public void printStatics() {
        print("");
    }
}
