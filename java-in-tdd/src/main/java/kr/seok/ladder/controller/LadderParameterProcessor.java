package kr.seok.ladder.controller;


import kr.seok.ladder.domain.Height;
import kr.seok.ladder.domain.Reward;
import kr.seok.ladder.view.InputView;
import kr.seok.ladder.wrapper.LadderRewards;
import kr.seok.ladder.wrapper.Participants;

import java.util.Arrays;
import java.util.Objects;

/**
 * The type Ladder parameter processor.
 */
public final class LadderParameterProcessor {

    private static final String GUIDE_ERR_NOT_EQUALS_SIZE = "참여자 수에 일치하는 결과 값을 입력해야 합니다.";
    private static final String GUIDE_ERR_INPUT_DATA = "입력 값이 없습니다.";
    private static final String SPLIT_DELIMITER = ",";

    private final InputView inputView;

    /**
     * Instantiates a new Ladder parameter processor.
     *
     * @param inputView the input view
     */
    LadderParameterProcessor(final InputView inputView) {
        this.inputView = inputView;
    }

    /**
     * Process users participants.
     *
     * @return the participants
     */
    Participants processUsers() {
        String participants = inputView.inputParticipants();
        checkNullOrEmpty(participants);
        return Participants.valueOf(parseStringToArrays(participants));
    }

    /**
     * Process ladder rewards ladder rewards.
     *
     * @param participantSize the participant size
     * @return the ladder rewards
     */
    LadderRewards processLadderRewards(final int participantSize) {
        String[] ladderRewards = parseStringToArrays(inputView.inputLadderRewards());
        Reward[] rewards = parseRewards(ladderRewards);
        if (ladderRewards.length != participantSize) {
            throw new IllegalArgumentException(GUIDE_ERR_NOT_EQUALS_SIZE);
        }
        return LadderRewards.valueOf(rewards);
    }

    /**
     * Process height height.
     *
     * @return the height
     */
    Height processHeight() {
        String ladderHeight = inputView.inputLadderHeight();
        checkNullOrEmpty(ladderHeight);
        return Height.valueOf(Integer.parseInt(ladderHeight));
    }


    /**
     * Input user result string.
     *
     * @return the string
     */
    String inputUserResult() {
        String userResult = inputView.inputUserResult();
        checkNullOrEmpty(userResult);
        return userResult;
    }

    private Reward[] parseRewards(final String[] ladderRewards) {
        return Arrays.stream(ladderRewards)
                .map(Reward::valueOf)
                .toArray(Reward[]::new);
    }

    private void checkNullOrEmpty(final String inputValue) {
        if (Objects.isNull(inputValue) || inputValue.isEmpty()) {
            throw new IllegalArgumentException(GUIDE_ERR_INPUT_DATA);
        }
    }

    private String[] parseStringToArrays(final String words) {
        return Arrays.stream(words.split(SPLIT_DELIMITER))
                .map(String::trim)
                .toArray(String[]::new);
    }
}
