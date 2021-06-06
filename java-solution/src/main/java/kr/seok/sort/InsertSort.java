package kr.seok.sort;

public class InsertSort {
    public int[] sort(int[] input, int length) {

        int tmp;

        for(int i = 1 ; i < length ; i++) {
            for (int j = i ; j > 0 ; j--) {

                if(input[j - 1] > input[j]) {
                    tmp = input[j - 1];
                    input[j - 1] = input[j];
                    input[j] = tmp;
                }
            }
        }
        return input;
    }
}
