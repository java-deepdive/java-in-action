package kr.seok.sort;

/**
 * 문자열 뒤집기
 * <p>
 * 해결책 두 가지
 * 1. 재귀
 * 2. 두 개의 포인터를 사용하여 순회, O(1) 공간
 */
public class ReverseString {

    public char[] reverseString(char[] s) {

        int left = 0, right = s.length - 1;

        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }

        return s;
    }
}
