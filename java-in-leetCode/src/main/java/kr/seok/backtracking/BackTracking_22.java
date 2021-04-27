package kr.seok.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class BackTracking_22 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        /*
            템플릿, 열기 괄호 개수, 닫기 괄호 개수, 현재 괄호, 최대 생성 개수
         */
        backtracking(result, 0, 0, "", n);

        return result;
    }

    /**
     * @param result 최종 결과 값을 담기 위한 템플릿
     * @param open   openBracket 개수
     * @param closed closedBracket 개수
     * @param cur    현재 bracket
     * @param max    최대 생성가능한 유요한 pair bracket 개수
     */
    private void backtracking(List<String> result, int open, int closed, String cur, int max) {

        // terminate check
        if (open == max && closed == max) {
            result.add(cur);
            return;
        }

        // 최대 갯수에 미치지 못하는경우 open bracket을 추가
        if (open < max) // add open bracket
            backtracking(result, open + 1, closed, cur + "(", max);

        if (closed < open) // add closed bracket
            backtracking(result, open, closed + 1, cur + ")", max);
    }


    public List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList<>();

        /*
            템플릿, 현재 문자, 최대 개수, bracket 균형
         */
        backtracking2(result, 0, 0, new StringBuilder(), n);

        return result;
    }

    private void backtracking2(List<String> result, int open, int close, StringBuilder sb, int max) {
        if (open == max && close == max) {
            result.add(sb.toString());
            return;
        }
        int len = open + close;

        if (open < max) {
            sb.append('(');
            backtracking2(result, open + 1, close, sb, max);
            sb.setLength(len);
        }

        if (open > close) {
            sb.append(')');
            backtracking2(result, open, close + 1, sb, max);
            sb.setLength(len);
        }
    }
}
