package kr.seok.ladder;


import kr.seok.ladder.domain.Height;
import kr.seok.ladder.domain.Ladder;
import kr.seok.ladder.domain.Participants;
import kr.seok.ladder.view.InputView;
import kr.seok.ladder.view.ResultView;

import java.util.Objects;

public class LadderRideGame {

    public void start() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        Participants participants = checkUsers(inputView.inputParticipants());
        Height height = checkHeight(inputView.inputLadderHeight());

        Ladder ladder = Ladder.valueOf(participants, height);

        resultView.printResult(ladder, participants);
    }

    private Height checkHeight(int inputLadderHeight) {
        return Height.valueOf(inputLadderHeight);
    }

    private Participants checkUsers(String inputParticipants) {
        if(Objects.isNull(inputParticipants) || inputParticipants.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }
        return Participants.valueOf(inputParticipants);
    }

}
