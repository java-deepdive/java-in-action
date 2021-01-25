package kr.seok.strNArr;

/**
 * 하나 빼기
 * 문자열을 편집하는 방법
 *  1. 문자 삽입
 *  2. 문자 삭제
 *  3. 문자 교체
 *
 *  문자열이 두 개 주어졌을 떄, 문자열을 같게 만들기 위해 편집 횟수가 1회 이내인지 확인하는 알고리즘
 *
 */
public class Ex5 {

    /*
        brute force
            - 한 번의 편집으로 생성할 수 있는 모든 문자열을 나열
            - 한 문자열을 삭제, 교체, 삽입하면서 다른 문자열과 비교

        각 연산이 무엇을 의미 하는지 생각해보기
            - 교체: 두 문자열에서 단 하나의 문자만 다르다.
            - 삽입: 특정 위치를 빈 공간으로 남겨두면 그 부분을 제외한 나머지 부분이 동일
            - 삭제: 삭제의 반대는 삽입

        접근 방법
            - 문자열의 길이를 알고 있으면 어떤 연산이 필요한지 알 수 있다.

     */
   boolean oneEditAway(String first, String second) {
       // 문자열 길이를 통해 필요한 해법을 선택
       if(first.length() == second.length()) { // 교체
           return oneEditReplace(first, second);

       } else if(first.length() + 1 == second.length()) { // 삽입
            return oneEditInsert(first, second);

       } else if(first.length() - 1 == second.length()) { // 삭제
           return oneEditInsert(second, first);
       }
       return false;
   }

    // 교체
    private boolean oneEditReplace(String first, String second) {
        boolean foundDifference = false;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (foundDifference) return false;
                foundDifference = true;
            }
        }
        return false;
    }

    // 삽입 또는 삭제
    private boolean oneEditInsert(String first, String second) {
        int idx1 = 0;
        int idx2 = 0;
        while (idx2 < second.length() && idx1 < first.length()) {
            if (first.charAt(idx1) != second.charAt(idx2)) {
                if (idx1 != idx2) {
                    return false;
                }
                idx2++;
            } else {
                idx1++;
                idx2++;
            }
        }
        return true;
    }

    /*
        중복되는 코드를 제거

     */

    boolean oneEditAway2(String first, String second) {
        if(Math.abs(first.length() - second.length()) > 1) { // 편집을 위한 삽입, 삭제가 2번 이상이면 false 처리
            return false;
        }

        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

        int index1 = 0;
        int index2 = 0;

        boolean foundDifference = false;
        // 문자열의 문자을 순서대로 체크
        while (index2 < s2.length() && index1 < s1.length()) {

            // 문자 비교. 같지 않은 경우
            if(s1.charAt(index1) != s2.charAt(index2)) {

                if(foundDifference) return false;
                foundDifference = true;

                // 교체의 경우 짧은 문자열의 포인터를 증가.
                if(s1.length() == s2.length()) index1++;
            } else {
                // 문자가 같은 경우 짧은 문자열의 포인터 증가
                index1++;
            }
            // 긴 문자열의 포인터는 항상 증가
            index2++;
        }
        return true;
    }

}
