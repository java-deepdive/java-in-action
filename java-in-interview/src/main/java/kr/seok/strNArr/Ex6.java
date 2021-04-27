package kr.seok.strNArr;

/**
 * 문자열 압축
 * <p>
 * 반복되는 문자의 개수를 세는 방식의 기본적인 문자열 압축 메서드를 작성하기
 * <p>
 * 압축된 문자열의 길이가 기존 문자열의 길이보다 길다면 기존 문자열을 반환해야 한다.
 * <p>
 * 문자열은 a - z 로만 이루어져있다.
 */
public class Ex6 {

    /*
        문자열을 합치는데 효율적으로 느림
     */
    private String compressBad(String str) {
        String compressedString = "";
        int countConsecutive = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            // 매번 현재 문자와 다음 문자를 비교, 같지 않으면 압축된 형태로 문자열에 추가
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                System.out.println((i + 1) + " >= " + str.length());
                compressedString += "" + str.charAt(i) + countConsecutive;
                countConsecutive = 0;
            }
        }
        return compressedString.length() < str.length() ? compressedString : str;
    }

    /*
        String 으로 작업되는 방식을 StringBuilder로 변경
     */
    private String compressBad2(String str) {
        StringBuilder compressedString = new StringBuilder();
        int countConsecutive = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            // 매번 현재 문자와 다음 문자를 비교, 같지 않으면 압축된 형태로 문자열에 추가
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedString
                        .append(str.charAt(i))
                        .append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressedString.length() < str.length()
                ? compressedString.toString() : str;
    }

    /*
        길이를 먼저 확인하여 속도와 공간적으로 이점을 보는 방식
        - 장점
            - StringBuilder의 크기를 미리 설정하여 필요한 만큼의 공간만 활용

        - 단점
            - 문자열을 두 번 순회해야한다는 점
            - 비슷한 코드가 중복된다는 점
     */
    private String compressBad3(String str) {
        int finalLength = countCompression(str);
        if (finalLength >= str.length()) return str;

        StringBuilder compressed = new StringBuilder(finalLength);
        int countConsecutive = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            // 매번 현재 문자와 다음 문자를 비교, 같지 않으면 압축된 형태로 문자열에 추가
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed
                        .append(str.charAt(i))
                        .append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.toString();
    }

    private int countCompression(String str) {
        int compressedLength = 0;
        int countConsecutive = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedLength += 1 + String.valueOf(countConsecutive).length();
                countConsecutive = 0;
            }
        }
        return compressedLength;
    }

    public static void main(String[] args) {
        String str = "aabccccaaa";
        System.out.println(new Ex6().compressBad(str));
    }
}
