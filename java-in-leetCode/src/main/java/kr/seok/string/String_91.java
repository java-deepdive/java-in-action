package kr.seok.string;

import java.util.HashMap;

/**
 * A - Z이 포함된 문자을 포함한 메시지를 숫자로 매핑되어 인코딩할 수 있다.
 */
public class String_91 {

    HashMap<Integer, Integer> memo = new HashMap<>();

    private int recursiveWithMemo(int index, String str) {
        if (index == str.length()) { // 문자열 길이가 인덱스와 같으면 1 반환
            return 1;
        }

        if (str.charAt(index) == '0') { // 0으로 시작하면 디코딩 할 수 없음
            return 0;
        }

        if (index == str.length() - 1) { // 문자열 길이가 인덱스와 같으면 1 반환
            return 1;
        }

        if (memo.containsKey(index)) { // 메모이제이션
            return memo.get(index);
        }

        int ans = recursiveWithMemo(index + 1, str);
        System.out.println(index + " :: " + (index + 2) + " :: " + str.substring(index, index + 2) + " :: " + ans);

        /*
            index : index + 2 : 'Z' = 26 이하만 반복
         */
        if (Integer.parseInt(str.substring(index, index + 2)) <= 26) {
            ans += recursiveWithMemo(index + 2, str);
            System.out.println(index + " :: " + (index + 2) + " :: " + str.substring(index, index + 2) + " :: " + ans);
        }

        memo.put(index, ans); // Save for memoization

        return ans;
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return recursiveWithMemo(0, s);
    }
}
