package kr.seok.strNArr;

/**
 * 중복이 없는가?
 * <p>
 * - 문자열이 주어졌을 때, 이 문자열에 같은 문자가 중복되어 등장하는지 확인하는 알고리즘 작성
 * <p>
 * # 자료구조를 추가로 사용하지 않고 풀 수 있는 알고리즘 고민
 */
public class Ex1 {

    /*
        문자열이 주어짐

        문자열에 같은 문자가 중복되어 등장하는지 확인

        - 사전 정보가 부족하여 생각해야하는 것

        1. ASCII 문자열인지, 유니코드 문자열인지?
            - ASCII문자열이 아닌경우 저장공간의 크기를 늘려야할 수 있다.

     */
    boolean isUniqueChars(String str) {
        // 문자 집합에서 i 번째 문자가 배열 내에 존재하는지 표시하는 boolean 배열을 사용

        /*
            문자열의 길이가 `문자 집합의 크기`보다 클 경우 false를 반환해도 됨
            문자 집합의 크기란게 뭘까?

            >> 문자 집합의 크기란? 개념 필요

            아스키는 7비트 인코딩으로, 33개의 출력 불가능한 제어 문자들과 공백을 비롯한 95개의 출력 가능한 문자들로 총128개로 이루어진다.

            - 정리
            아스키 코드 128번짜지 문자 코드로 나타낼 수 있다. >> 추가 저장공간을 사용하지 않고 확인할 수 있는 키워드

         */
        if (str.length() > 128) return false;

        boolean[] char_set = new boolean[128];

        /* 문자 반복 */
        for (int i = 0; i < str.length(); i++) {

            int val = str.charAt(i);

            /* 특정 문자가 이미 존재함을 표시 */
            if (char_set[val]) return false;

            /* 문자 확인 후 존재하지 않으면 ascii 코드 인덱스의 boolean 값을 true 로 저장 */
            char_set[val] = true;
        }

        /* 중복된 값이 존재하지 않으면 true 반환 */
        return true;
    }

    /*
        결론

        시간 복잡도 O(n): n은 문자열의 길이
        공간 복잡도 O(1)
     */

    /*
        비트 백터를 이용한 필요 공간 감소 리펙토링

        - 사전조건: 문자열은 a - z까지 구성 되는 것으로 가정


        이런 알고리즘 생각을 할 순 있을라나?
     */

    boolean isUniqueChars2(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            // char 값을 0부터 시작하게끔 초기값을 설정
            int val = str.charAt(i) - 'a';

            System.out.println("문자: " + str.charAt(i) + " :: checker : " + checker + " :: 비트 연산: " + (1 << val) + " :: 비트 이동 및 and 연산: " + (checker & (1 << val)));
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            System.out.println(" or 연산 : " + (checker |= (1 << val)));
            checker |= (1 << val);
        }
        return true;
    }

    /*
        1. 문자열 내의 각 문자를 다른 모든 문자와 비교
            - 이럼 O(n^2) 시간이 걸리고 공간 복잡도 O(1)
        2. 입력 문자열을 수정해도 되는 경우, O(nlogn) 시간에 문자열을 정렬한 뒤 문자열을 처음처럼 훑어 나가면서 인접한 문자가 동일하지 검사할 수 있다.
            - 이때 많은 정렬 알고리즘이 공간을 추가로 쓴다.
     */
}
