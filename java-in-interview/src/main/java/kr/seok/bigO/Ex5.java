package kr.seok.bigO;

public class Ex5 {
    public static void main(String[] args) {
        new Ex5().printUnorderedPairs(new int[]{1, 2, 3}, new int[]{1, 2, 3});
    }

    void printUnorderedPairs(int[] arrayA, int[] arrayB) {
        for (int i = 0; i < arrayA.length; i++) {       // O(A)
            for (int j = 0; j < arrayB.length; j++) {   // O(B)
                for (int k = 0; k < 100000; k++) {      // O(100000)
                    System.out.println(arrayA[i] + "," + arrayB[j]);
                }
            }
        }
        // 상수항을 제외한 시간 복잡도: O(AB)
    }
}
