package kr.seok.dynamic;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 * <p>
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 */
public class Dynamic_70 {

    public int climbStairs_BruteForce(int n) {
        return climb_Stairs(0, n);
    }

    // climbStairs(i, n) = (i + 1, n) + climbStairs(i + 2, n)
    public int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }

    public int climbStairs_Recursion_with_Memoization(int n) {
        int[] memo = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }

    public int climb_Stairs(int i, int n, int[] memo) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    }

    // dp[i] = dp[i−1] + dp[i−2]
    public int climbStairs_DynamicProgramming(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // Fib(n) = Fib(n−1) + Fib(n−2)
    public int climbStairs_FibonacciNumber(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    // 직접 계산을 한 번 해보기
    // 다이나믹 프로그래밍은 점화식을 찾아야 하는 듯
    // 주어진 조건이 있고 순차적으로 또는 어떠한 규칙으로 연산된 뒤 그 중의 결과 값을 원하는 경우 연산되는 값을 저장해 둔 뒤 특정 값을 반환
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
