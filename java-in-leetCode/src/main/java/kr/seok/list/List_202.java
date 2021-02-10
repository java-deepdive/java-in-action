package kr.seok.list;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number n is happy.
 *
 * A happy number is a number defined by the following process:
 *
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 *
 * Input: n = 19
 * Output: true
 *
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 02 = 1
 *
 */
public class List_202 {
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10; // 나머지 값
            n = n / 10; // 몫
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappyHash(int n) {
        Set<Integer> fined = new HashSet<>();
        while (n != 1 && !fined.contains(n)) {
            fined.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
}
