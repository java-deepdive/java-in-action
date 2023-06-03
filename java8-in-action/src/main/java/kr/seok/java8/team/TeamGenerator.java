package kr.seok.java8.team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeamGenerator {

    private TeamGenerator() {
    }

    public static void makeReviewerAndAssignee(List<String> participants) {

        // Shuffle the list to randomize team assignments
        Collections.shuffle(participants);

        List<ReviewPair> round1 = createPairs(participants);
        printPairs(round1);

        List<ReviewPair> round2 = createPairsForRound2(round1);
        printPairs(round2);
    }

    private static List<ReviewPair> createPairs(List<String> participants) {
        List<ReviewPair> pairs = new ArrayList<>();
        for (int i = 0; i < participants.size(); i += 2) {
            String reviewee = i + 1 < participants.size() ? participants.get(i + 1) : null;
            pairs.add(new ReviewPair(participants.get(i), reviewee));
        }
        return pairs;
    }

    private static void printPairs(List<ReviewPair> pairs) {
        for (ReviewPair pair : pairs) {
            System.out.println("Reviewer: " + pair.reviewer + ", Assignee: " + (pair.reviewee == null ? "none" : pair.reviewee));
        }
    }

    private static List<ReviewPair> createPairsForRound2(List<ReviewPair> round1) {
        List<String> reviewers = new ArrayList<>();
        List<String> reviewees = new ArrayList<>();

        for (ReviewPair pair : round1) {
            reviewers.add(pair.reviewee);
            reviewees.add(pair.reviewer);
        }

        Collections.rotate(reviewees, 1);

        List<ReviewPair> round2 = new ArrayList<>();
        for (int i = 0; i < reviewers.size(); i++) {
            round2.add(new ReviewPair(reviewers.get(i), reviewees.get(i)));
        }

        return round2;
    }

    static class ReviewPair {
        String reviewer;
        String reviewee;

        ReviewPair(String reviewer, String reviewee) {
            this.reviewer = reviewer;
            this.reviewee = reviewee;
        }

        // Flip the roles for the next round
        ReviewPair flipRoles() {
            return new ReviewPair(this.reviewee, this.reviewer);
        }
    }
}
