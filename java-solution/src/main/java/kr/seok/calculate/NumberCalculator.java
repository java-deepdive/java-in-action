package kr.seok.calculate;

public class NumberCalculator {
    public int solution(int n) {
        int answer = 0;

        if (n > 10000) return 0;

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = i; j <= n; j++) {
                sum += j;

                if (sum == n) {
                    answer++;
                    break;
                } else if (sum > n) {
                    break;
                }
            }
        }
        return answer;
    }
}
