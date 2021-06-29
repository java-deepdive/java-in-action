package kr.seok.ladder.view;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * The type Input view.
 */
public class InputView {

    /**
     * The constant GUIDE_LADDER_INPUT_PARTICIPANTS.
     */
    public static final String GUIDE_LADDER_INPUT_PARTICIPANTS = "참여할 사람 이름을 입력하세요. (이름은 쉼표( , )로 구분하세요.";
    /**
     * The constant GUIDE_LADDER_INPUT_LADDER_SIZE.
     */
    public static final String GUIDE_LADDER_INPUT_LADDER_SIZE = "\n최대 사다리 높이는 몇 개인가요?";
    /**
     * The constant GUIDE_LADDER_INPUT_RESULT.
     */
    public static final String GUIDE_LADDER_INPUT_RESULT = "\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    /**
     * The constant GUIDE_LADDER_INPUT_USER.
     */
    public static final String GUIDE_LADDER_INPUT_USER = "\n결과를 보고 싶은 사람은?";
    private final Scanner in = new Scanner(System.in);

    /**
     * Input participants string.
     *
     * @return the string
     */
    public String inputParticipants() {
        out.println(GUIDE_LADDER_INPUT_PARTICIPANTS);
        return in.nextLine();
    }

    /**
     * Input ladder rewards string.
     *
     * @return the string
     */
    public String inputLadderRewards() {
        out.println(GUIDE_LADDER_INPUT_RESULT);
        return in.nextLine();
    }

    /**
     * Input ladder height string.
     *
     * @return the string
     */
    public String inputLadderHeight() {
        out.println(GUIDE_LADDER_INPUT_LADDER_SIZE);
        return in.nextLine();
    }

    /**
     * Input user result string.
     *
     * @return the string
     */
    public String inputUserResult() {
        out.println(GUIDE_LADDER_INPUT_USER);
        return in.nextLine();
    }
}
