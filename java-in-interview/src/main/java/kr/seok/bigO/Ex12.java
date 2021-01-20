package kr.seok.bigO;

public class Ex12 {

    /*
        순열 구하기
     */
    void permutation(String str) {
        permutation(str, "");
    }

    /*
        해당 함수가 얼마나 많이 호출 되는지
        각 호출마다 걸리는 시간이 얼마나 되는지 살펴보기

     */
    void permutation(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }
}
