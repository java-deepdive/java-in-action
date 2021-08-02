package kr.seok.ladder.view;


import kr.seok.ladder.domain.Bar;
import kr.seok.ladder.domain.Reward;
import kr.seok.ladder.domain.User;
import kr.seok.ladder.wrapper.Ladder;
import kr.seok.ladder.wrapper.LadderRewards;
import kr.seok.ladder.wrapper.Line;
import kr.seok.ladder.wrapper.Participants;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.out;

/**
 * The type Result view.
 */
public class ResultView {

    /**
     * The constant GUIDE_LADDER_RESULT.
     */
    public static final String GUIDE_LADDER_RESULT = "\n실행 결과";
    private static final String LADDER_VERTICAL_LINE = "|";
    private static final String STRING_FORMAT_RENDER = "%6s";
    private static final String GUIDE_HEAD_LINE = "\n사다리 타기 결과\n";
    private static final String LADDER_HORIZON = "-----";
    private static final String LADDER_EMPTY = "     ";
    private static final String EMPTY_LINE = "";

    /**
     * Print result.
     *
     * @param ladder        the ladder
     * @param participants  the participants
     * @param ladderRewards the ladder rewards
     */
    public void printResult(final Ladder ladder, final Participants participants, final LadderRewards ladderRewards) {
        printHeader();
        printNames(participants);
        printLadder(ladder);
        printLadderRewards(ladderRewards);
        out.println();
    }

    private void printHeader() {
        out.println(GUIDE_HEAD_LINE);
    }

    private void printNames(final Participants participants) {
        participants.getUsers()
                .stream()
                .map(this::parseName)
                .forEach(out::print);
        out.println();
    }

    private String parseName(final User user) {
        return String.format(STRING_FORMAT_RENDER, user);
    }

    private void printLadder(final Ladder ladder) {
        ladder.lines()
                .stream()
                .map(this::renderLadder)
                .forEach(out::println);
    }

    private void printLadderRewards(final LadderRewards ladderRewards) {
        ladderRewards.getRewards()
                .stream()
                .map(this::parseFormat)
                .forEach(out::print);
        out.println();
    }

    private String parseFormat(final Reward ladderReward) {
        return String.format(STRING_FORMAT_RENDER, ladderReward);
    }

    private String renderLadder(final Line line) {
        return line.points().bars()
                .stream()
                .map(this::renderPerPoint)
                .collect(Collectors.joining(LADDER_VERTICAL_LINE, EMPTY_LINE, LADDER_VERTICAL_LINE));
    }

    private String renderPerPoint(final Bar bar) {
        if (bar.isExist()) {
            return LADDER_HORIZON;
        }
        return LADDER_EMPTY;
    }

    /**
     * Print user result.
     *
     * @param allUser the all user
     */
    public void printUserResult(final List<String> allUser) {
        out.println(GUIDE_LADDER_RESULT);
        allUser.forEach(out::println);
    }

    /**
     * Print user result.
     *
     * @param user the user
     */
    public void printUserResult(final String user) {
        out.println(GUIDE_LADDER_RESULT);
        out.println(user);
    }
}
