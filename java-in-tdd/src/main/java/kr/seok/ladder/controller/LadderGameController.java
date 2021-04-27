package kr.seok.ladder.controller;


import kr.seok.ladder.domain.Height;
import kr.seok.ladder.domain.User;
import kr.seok.ladder.generator.DefaultLineGenerator;
import kr.seok.ladder.generator.LineGenerator;
import kr.seok.ladder.service.LadderFactory;
import kr.seok.ladder.view.InputView;
import kr.seok.ladder.view.ResultView;
import kr.seok.ladder.wrapper.Ladder;
import kr.seok.ladder.wrapper.LadderResult;
import kr.seok.ladder.wrapper.LadderRewards;
import kr.seok.ladder.wrapper.Participants;

import static kr.seok.ladder.controller.LadderParameterHelper.parseArgumentResolver;

public class LadderGameController {

    public static final String GUIDE_LADDER_END_SIGNATURE = "all";
    private final LadderParameterProcessor processor;
    private final ResultView resultView;
    private final LineGenerator generator;

    public LadderGameController(final InputView inputView, final ResultView resultView) {
        this(new LadderParameterProcessor(inputView), resultView, new DefaultLineGenerator());
    }

    public LadderGameController(final LadderParameterProcessor processor, final ResultView resultView, final LineGenerator generator) {
        this.processor = processor;
        this.resultView = resultView;
        this.generator = generator;
    }

    public void start() {
        Participants participants = parseArgumentResolver(processor::processUsers);
        LadderRewards rewards =
                parseArgumentResolver(() -> processor.processLadderRewards(participants.size()));
        Height height = parseArgumentResolver(processor::processHeight);

        Ladder ladder = LadderFactory.valueOf(participants, height, generator);
        LadderResult ladderResult = LadderFactory.rideLadder(participants, ladder, rewards);

        resultView.printResult(ladder, participants, rewards);

        String user;
        do {
            user = parseArgumentResolver(processor::inputUserResult);
        } while (!isOneOrAll(ladderResult, user));
    }

    private boolean isOneOrAll(final LadderResult ladderResult, final String user) {
        if (user.equals(GUIDE_LADDER_END_SIGNATURE)) {
            resultView.printUserResult(ladderResult.findAll());
            return true;
        }
        User findUser = User.valueOf(user);
        resultView.printUserResult(ladderResult.findOf(findUser));
        return false;
    }


}
