package kr.seok.strNArr;

/**
 * URLify
 *  - 문자열에 들어있는 모든 공백을 `%20` 으로 바꾸는 메서드를 작성하기
 *
 *  최종적으로 모든 문자를 다 담을 수 있을 만큼 충분한 공간이 이미 확보되어 있으며
 *
 *  문자열의 최종 길이가 함께 주어진다고 가정해도 된다.
 *
 *  char[] 이용하기
 *
 */
public class Ex3 {

    /*
        문자열 조작문제
            - 문자열을 뒤에서부터 거꾸로 편집하기

        이 방식은 마지막 부분에 여유 공간을 만들어 유용하게 사용할 수 있다.
        이 방법은 덮어쓸 걱정을 하지 않고 문자를 바꿀 수 있음


        이 알고리즘에서는 문자열을 두 번 훑는다.

        1. 처음 문자열 내에 얼마나 많은 공백 문자가 있는지 살핀다.
            - 반복을 통해 최종 문자열에 추가 공간이 얼마나 필요한지 계산한다.
        2. 역방향으로 진행하면서 실제 문자열을 편집한다.
            - 공백을 만나면 다음 위치에 %20을 복사하고, 공백 문자가 아니면 원래 문자를 복사한다.

     */

    public char[] replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0;
        int index, i = 0;

        // 공백 개수계산하여 추가 공간 확보하기
        for (i = 0; i < trueLength; i++) {
            if (str[i] == ' ') spaceCount++;
        }

        // 13 + 2 * 2 = 17
        index = trueLength + spaceCount * 2;

        // 배열 뒷쪽부터 값을 계산하기 위해서 배열의 끝에 값 추가
        // 13 < 13
        if(trueLength < str.length) str[trueLength] = '\0'; // 배열의 끝

        // 배열의 첫 번째 인덱스까지 값 채우기
        for (i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                // 거꾸로 %20 추가하기
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
        return str;
    }
}
