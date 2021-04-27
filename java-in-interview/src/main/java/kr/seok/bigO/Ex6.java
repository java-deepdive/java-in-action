package kr.seok.bigO;

public class Ex6 {

    void reverse(int[] array) {

        for (int i = 0; i < array.length / 2; i++) {
            // 배열 끝부터 돌아오는 인덱스 계산
            int other = array.length - i - 1;

            System.out.println(array[i] + " :: " + array[other]);

            // swap
            int temp = array[i];
            array[i] = array[other];
            array[other] = temp;
        }
    }

    public static void main(String[] args) {
        new Ex6().reverse(new int[]{1, 2, 3, 4});
    }
}
