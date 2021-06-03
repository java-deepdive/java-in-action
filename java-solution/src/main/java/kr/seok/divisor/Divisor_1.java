package kr.seok.divisor;

public class Divisor_1 {

    public int solution(int left, int right) {
        int answer = 0;
        int[] range = new int[right - left + 1];

        for(int i = left ; i <= right ; i++) {
            range[right - i] = i;
        }

        for(int item : range) {
            answer += divisor(item);
        }

        return answer;
    }

    private int divisor(int item) {
        int cnt = 0;
        for(int i = 1 ; i <= item ; i++) {
            if(item % i == 0) {
                cnt++;
            }
        }
        return cnt % 2 == 0 ? item : -(item);
    }
}
