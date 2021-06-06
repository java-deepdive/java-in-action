package kr.seok.toptown;

import java.util.Stack;

/**
 * 짝지어 제거하기
 * 알파벳 소문자로 이루어진 문자열을 가지고 시작한다.
 * <p>
 * 먼저 문자열에서 같은 알파뱃이 2개 붙어있는 짝을 찾는다.
 * <p>
 * 그 다음, 그 둘을 제거한 뒤, 앞뒤로 문자열을 이어붙인다.
 * <p>
 * 이 과정을 반복해서 문제열을 모두 제거한다면 짝지어 제거하기가 종료된다.
 */
public class PairRemove {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (stack.isEmpty()) {
                stack.push(c);
            } else if (stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.size() > 0 ? 0 : 1;
    }

}
