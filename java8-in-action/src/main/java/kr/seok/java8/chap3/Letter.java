package kr.seok.java8.chap3;

public class Letter {
    public static String addHeader(String text) {
        return "From SR: " + text;
    }
    public static String addFooter(String text) {
        return text + " Kind regards";
    }
    public static String checkSpelling(String text) {
        return text.replaceAll("labda", "lambda");
    }
}
