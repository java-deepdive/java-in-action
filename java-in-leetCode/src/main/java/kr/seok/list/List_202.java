package kr.seok.list;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number n is happy.
 * <p>
 * A happy number is a number defined by the following process:
 * <p>
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 * <p>
 * Input: n = 19
 * Output: true
 * <p>
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 02 = 1
 */
public class List_202 {
    /*
        주어진 숫자의 각 자리수를 제곱하여 합산
     */
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10; // 나머지 값
            n = n / 10; // 몫
            totalSum += d * d;
        }
        return totalSum;
    }

    /*
        HashSet을 사용하여 주기를 감지

        예시 몇 가지를 만들어 본다.
        49 = 7^2
        97 = 4^2 + 9^2

        순차적으로 서술
        1. 주어진 숫자의 자리수만큼 반복하여 10으로 나눈 나머지 값들을 합산하여 다음 노드값을 생성
        2. 노드를 생성 및 저장하여 새로 생성된 노드가 기존에 생성했던 노드이거나 노드의 값이 1인 경우 루프에서 종료
        3. 결과 노드 값이 1인 경우 happy number 이므로 true를 반환, 그게 아닌 경우 false를 반환

        hashset을 활용하는 방법은 시간복잡도는 O(logN), 공간복잡도는 O(logN)

     */
    public boolean isHappyHash(int n) {
        Set<Integer> fined = new HashSet<>();
        while (n != 1 && !fined.contains(n)) { // n이 1이 아니고 노드 set에 포함되어 있지 않는 경우에 반복
            fined.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    /*
        느린 러너(1)와 빠른 러너(2)를 추적

        Floyd Cycle의 특징

        n이 happy number인 경우, 즉 사이클이 없는 경우 빠른 주자는 결국 느린 주자보다 먼저 1이 된다.
        n이 happy number가 아닌 경우, 결국 빠른 주자와 느린 주자가 같은 숫자가 된다.

        시간 복잡성: O(logN)
        공간 복잡성: 주기를 감지하기 위해서 hashSet이 필요하지 않으므로 O(1)
     */
    public boolean isHappyFloydCycle(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);

        // 빠른 주자만 1이 되는 경우 cycle
        // slow & fast 가 같은 경우 cycle이 아님
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }
}
