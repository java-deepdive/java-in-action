package kr.seok.bigO;

/* 아래 코드의 시간복잡도? */
public class Ex1 {
    void foo(int[] array) {
        int sum = 0;
        int product = 1;

        /*
            0 + 1 = 1
            1 + 2 = 3
            3 + 3 = 6
            6 + 4 = 10
         */
        for(int i = 0 ; i < array.length ;i++) { // O(n)
            sum += array[i];
        }

        /*
            1 * 1 = 1
            1 * 2 = 2
            2 * 3 = 6
            6 * 4 = 24
         */
        for(int i = 0 ; i < array.length ;i++) { // O(n)
            product *= array[i];
        }

        System.out.println(sum + ", " + product);
    }
}
