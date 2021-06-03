package kr.seok.calculate;

public class StringAdd {
    public String solution1(String a, String b) {
        int numberA = 0;
        int numberB = 0;

        numberA = parseInt(a, numberA);
        numberB = parseInt(b, numberB);

        return String.valueOf(numberA + numberB);
    }

    private int parseInt(final String a, int tmp) {
        for (int i = 0; i < a.length(); i++) {
            int element = a.charAt(i) - '0';
            tmp = tmp * 10 + element;
        }
        return tmp;
    }
}
