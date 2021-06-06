package kr.seok.math;

/**
 * 부호있는 32 비트 정수가 주어지면 숫자를 반대로x 반환 합니다.
 * 반전으로 인해 값이 부호있는 32 비트 정수 범위를 벗어나면를 반환 합니다.
 * 환경에서 64 비트 정수 (부호 있음 또는 부호 없음)를 저장할 수 없다고 가정합니다.
 */
public class ReverseInteger {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
