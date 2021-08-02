package kr.seok.sort;

public class BubbleSort {

    // 22
    public int[] sort3(int[] input, int length) {
        int count = 0;

        for (int i = 0; i < length - 1; i++) {
            int exchange = 0;
            for (int j = length - 1; j > i; j--) {
                if (input[j - 1] > input[j]) {

                    System.out.println(input[j - 1] + " :: " + input[j]);
                    int tmp = input[j - 1];
                    input[j - 1] = input[j];
                    input[j] = tmp;
                    System.out.println(input[j - 1] + " :: " + input[j]);
                    exchange++;
                }
                count++;
            }
            if (exchange == 0) break;
        }
        System.out.println(count);
        return input;
    }

    // 36
    public int[] sort2(int[] input, int length) {
        int tmp;

        // 순차적으로 정렬을 해간다.
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (input[i] > input[j]) {
                    tmp = input[i];
                    input[i] = input[j];
                    input[j] = tmp;
                }
                count++;
            }
        }
        System.out.println(count);
        return input;
    }

    // 28
    public int[] sort(int[] input, int length) {

        int tmp;
        int count = 0;
        for (int i = length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {

                if (input[j] > input[j + 1]) {
                    tmp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = tmp;
                }
                count++;
            }
        }
        System.out.println(count);
        return input;
    }
}
