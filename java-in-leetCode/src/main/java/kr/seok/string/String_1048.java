package kr.seok.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class String_1048 {

    public int longestStrChain(String[] words) {
        Set<String> wordsPresent = Set.of(words);
        Map<String, Integer> memoization = new HashMap<>();

        int answer = 0;
        for (String item : wordsPresent) {
            // 반복할거고, 반복되는 단어의 값을 비교 및 확인해야 한다.

            answer = Math.max(answer, dfs(wordsPresent, memoization, item));
        }
        return answer;
    }

    private int dfs(Set<String> words, Map<String, Integer> memoization, String currentWord) {

        if (memoization.containsKey(currentWord)) {
            return memoization.get(currentWord);
        }

        int maxLength = 1;

        StringBuilder sb = new StringBuilder(currentWord);

        for (int i = 0; i < currentWord.length(); i++) {
            sb.deleteCharAt(i);
            String newWord = sb.toString();

            if (words.contains(newWord)) {
                int currentLength = dfs(words, memoization, newWord) + 1;
                maxLength = Math.max(maxLength, currentLength);
            }
            sb.insert(i, currentWord.charAt(i));
        }
        memoization.put(currentWord, maxLength);
        return maxLength;
    }
}
