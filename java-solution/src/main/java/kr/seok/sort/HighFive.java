package kr.seok.sort;

import java.util.*;

/**
 * 학생들의 점수 목록을 감안하여
 */
public class HighFive {
    private int K;

    public int[][] highFive(int[][] items) {
        this.K = 5;
        TreeMap<Integer, Queue<Integer>> allScores = new TreeMap<>();

        for (int[] item : items) {
            int id = item[0];
            int score = item[1];
            if (!allScores.containsKey(id))
                // max heap
                allScores.put(id, new PriorityQueue<>((a, b) -> b - a));
            // Add score to the max heap
            allScores.get(id).add(score);
        }

        List<int[]> solution = new ArrayList<>();

        for (int id : allScores.keySet()) {
            int sum = 0;
            // obtain the top k scores (k = 5)
            for (int i = 0; i < this.K; ++i)
                sum += allScores.get(id).poll();
            solution.add(new int[]{id, sum / this.K});
        }

        int[][] solutionArray = new int[solution.size()][];

        return solution.toArray(solutionArray);
    }
}
