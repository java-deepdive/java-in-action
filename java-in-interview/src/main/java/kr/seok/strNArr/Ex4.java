package kr.seok.strNArr;

/**
 * 회문 순열
 * 주어진 문자열이 회문(palindrome)의 순열인지 확인하는 함수 작성
 * <p>
 * 회문이란?
 * - 회문이란 앞으로 읽으나 뒤로 읽으나 같은 단어 혹은 구절을 의미
 * <p>
 * 순열이란?
 * - 순열이란 문자열을 재배치하는 것
 * <p>
 * 회문의 순열이란?
 * - 문자열을 배치하여 회문이 가능한 단어
 * <p>
 * 두 가지 개념을 합쳐 놓은 것
 */
public class Ex4 {
    /*
        어느 방향으로 읽어도 같은 문자열이 되도록 만들수 있는지 확인하기

        해당 개념이 적용되기 위한 사전 조건
            - 모든 문자가 짝수개 존재하는 경우 절반은 왼쪽에 나머지 절반은 오른쪽에 놓는 방법
            - 홀수개인 경우, 단 하나의 문자만 존재하며 그 값이 중앙에 있고 나머지 값들을 양쪽에 놓는 방법
     */

    boolean isPermutationOfPalindrome(String phrase) {
        int[] table = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }


    /**
     * @return 각 문자가 몇 번 등장했는지 카운트 값을 저장한 배열을 반환
     */
    private int[] buildCharFrequencyTable(String phrase) {
        //
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
            }
        }
        return table;
    }

    /**
     * 각 문자에 숫자를 대응
     *
     * @return a -> 0, b -> 1 ... 대소문자 구분이 없고, 문자가 아닌 경우 -1로 대응
     */
    private int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    /**
     * @return 홀수 문자가 한 개 이상 존재하는지 확인
     */
    private boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        // 문자 개수를 저장한 배열의 값을 반복하면서 odd를 찾으면 false를 반환
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) return false;
                foundOdd = true;
            }
        }
        return true;
    }

    /*
        위 알고리즘의 탐색 시간은 O(n) 이다.

        위 해법에서 문자열을 훑어나가면서 동시에 개수를 확인하도록 개선
     */

    boolean isPermutationOfPalindrome2(String phrase) {
        int countOdd = 0;
        int[] table = new int[
                Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) { // 해당 문자가 일단 범위 내에 존재.
                table[x]++; // table에 존재하는 문자에 대한 count를 증가
                if (table[x] % 2 == 1) { // table의 count가 홀수 인경우 count값을 증가
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }

    /*
        위 해법의 시간 복잡도는 변화가 없지만 해시테이블을 이용하였지만 각 문자마다 수행해야 할 코드가 늘어남


        한 개의 정수 변수를 사용하여 비트 백터를 활용
        알파벳을 0 ~ 25까지의 숫자로 치환하여 해당 문자가 등장할 때마다 치환된 위치의 비트값을 변경
        마지막으로 한 개 이하의 비트가 1로 세팅되어 있는지 확인

        이건 일단은 패스
     */

    boolean isPermutationOfPalindrome3(String phrase) {
        int bitVector = createBitVector(phrase);
        return bitVector == 0 || checkExactlyOneBitSet(bitVector);
    }

    private int createBitVector(String phrase) {
        int bitVector = 0;
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }

    private int toggle(int bitVector, int x) {
        if (x < 0) return bitVector;
        // 쉬프트 이동
        int mask = 1 << x;
        // and 연산 처리
        if ((bitVector & mask) == 0) {
            bitVector |= mask;
        } else {
            bitVector &= ~mask;
        }
        return bitVector;
    }

    private boolean checkExactlyOneBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }
}
