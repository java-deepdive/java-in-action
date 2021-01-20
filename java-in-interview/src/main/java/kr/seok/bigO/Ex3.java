package kr.seok.bigO;

public class Ex3 {
    /*
        1, 2
        1, 3
        1, 4

        2, 3
        2, 4

        3, 4
     */
    void printUnorderedPairs(int[] array) {
        for (int i = 0; i < array.length; i++) { // O(n)
            /*
                안쪽 루프 i + 1부터 시작

                N - 1
                N - 2
                N - 3
                ...

                2
                1

                결국 역순으로 하면 1부터 N - 1 까지 반복

                1에서 N - 1까지의 합을 수학식으로 표기하면 N(N-1) / 2


                여기서 알 수 있는 것

                j가 i 보다 큰 모든 (i, j) 쌍을 반복

                전체 쌍의 개수는 N^2

                이 중 절반이 i < j
                또 다른 절반이 i > j

                따라서 이 코드는 대략 전체 쌍의 절반인 N^2 / 2개를 사용

                O(N^2) 시간이 걸린다.

             */
            for (int j = i + 1; j < array.length; j++) { // O(n)
                System.out.println(array[i] + ", " + array[j]);
            }
        }
    }

    public static void main(String[] args) {
        new Ex3().printUnorderedPairs(new int[]{1, 2, 3, 4});
    }
}
