package kr.seok.bigO;

public class Ex8 {
    /*
        여러 개의 문자열로 구성된 배열이 주어졌을때
        각각의 문자열을 먼저 정렬
        그 다음에 전체 문자열을 사전 순으로 다시 정렬하는 알고리즘

        이러한 알고리즘이 주어졌을 때 수행 시간?

     */
    void sorted(String[] s) {

        /*
            생각해야 하는 것
                1. 각 문자열을 정렬
                2. 전체 문자열을 다시 사전순으로 정렬

            가장 길이가 긴 문자열의 길이를 s
            배열의 길이를 a
            라 정의

            - 각 문자열 정렬

                각 문자열을 정하는데 O(slogs)가 소요
                a 개의 문자열 모두 정렬해야하므로 총 O(a * s logs)가 소요

            - 전체 문자열을 사전 순으로 정렬

                문자열 두 개를 비교하는데 O(s) 시간이 소요
                총 O(aloga)번을 비교

                결론적으로 O(a * sloga)가 소요

            - 위 두 부분 합산
                전체 시간 복잡도 O(a * s(loga + logs)) 가 된다.


         */
        int a = s.length;
        String[] sorted = eachOtherSorted(s);
    }

    private String[] eachOtherSorted(String[] s) {
        return new String[0];
    }
}
