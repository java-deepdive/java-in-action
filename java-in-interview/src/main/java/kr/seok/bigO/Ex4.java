package kr.seok.bigO;

public class Ex4 {
    /*
        바깥 루프가 반복한다는 것은 분명함

        바깥 루프의 상태에 따라 달라지지만, 반복 횟수의 평균을 구할 순 있다.

        1 ~ 10의 평균 -> N / 2

        따라서 Nested loop의 평균 반복 횟수는 N / 2이고
        바깥 루프는 N 번 반복되니 N^2 / 2

        즉, O(N^2)이 된다.

        서로 다른 배열을 사용하는 예시

        1, 2
        1, 3
        1, 4

        2, 3
        2, 4

        3, 4
     */
    void printUnorderedPairs(int[] arrayA, int[] arrayB) {
        for (int i = 0; i < arrayA.length; i++) {
            for (int j = 0; j < arrayB.length; j++) {
                /*
                    j = i + 1과 비교

                    73p 중간 무슨 내용임?

                 */
                if (arrayA[i] < arrayB[j]) {
                    System.out.println(arrayA[i] + ", " + arrayB[j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        new Ex4().printUnorderedPairs(new int[]{1, 2, 3, 4}, new int[]{3, 4});
    }
}
