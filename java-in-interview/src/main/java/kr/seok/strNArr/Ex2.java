package kr.seok.strNArr;

import java.util.Arrays;

/**
 * - 순열 확인
 * 문자열 두 개가 주어졌을 떄, 이 둘의 순열 관계인지 확인하는 메서드 작성
 *
 * 순열 관계에 대한 정의?
 * - 서로 다른 n개의 원소 중 r개를 중복하지 않고 선택해 순서대로 나열한 것
 * - 중복하지 않고 나열한다는 점에서 순서가 의미가 있음
 *
 */
public class Ex2 {
    /*
        사전 정보
        - 대 소문자를 구분 해야 하는지?
        - 공백에 대한 처리?

        - 현재 코드는 대소문자 구별하며 공백도 문자로 취급

        조건
            - 문자열의 길이가 다르면 서로 순열관계에 있을 수 없다.

        최적은 아니지만 깔끔하고 이해하기 쉽고 실용적인 해결법

     */
    public boolean permutation(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        return sort(s).equals(sort(t));
    }

    public String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    /*
        효율적으로 개선을 한 번 해보자

        문자열에 포함된 문자의 출현 횟수가 같은지 검사

        [순열의 정의를 이용]
            - 두 문자열이 동일한 문자 개수를 갖고 있다는 점을 이용

        [구현 방식]
            - 배열을 두 개 사용하여 각 문자열 내의 문자 출현 횟수를 기록하여 비교

        문자 집합으로 ASCII를 사용하는 경우에 제한
     */

    boolean permutation2(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        // 문자
        int[] letters = new int[128];

        // 첫번째 문자열을 char 타입 배열로 변경
        char[] s_array = s.toCharArray();
        for(char c : s_array) {
            // 해당 인덱스에 + 1 처리
            letters[c]++;
            System.out.println(" s : " + letters[c]);
        }

        for(int i = 0 ; i < t.length() ; i++) {
            int c = t.charAt(i);

            // letters 라는 공간에 - 1 처리
            letters[c]--;

            System.out.println(" c : " + letters[c]);
            // 0보다 작은 값이 저장? 된다라는 말은 +1 -1 이 아니라는 것
            if(letters[c] < 0) {
                return false;
            }
        }

        return true;
    }
}
