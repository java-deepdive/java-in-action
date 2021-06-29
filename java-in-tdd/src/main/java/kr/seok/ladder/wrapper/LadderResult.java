package kr.seok.ladder.wrapper;


import kr.seok.ladder.domain.Reward;
import kr.seok.ladder.domain.User;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The type Ladder result.
 */
public class LadderResult {

    /**
     * The constant GUIDE_ERR_NOT_FOUND_USER.
     */
    public static final String GUIDE_ERR_NOT_FOUND_USER = "존재하지 않는 아이디 입니다.";
    private final Map<User, Reward> rewardResult;

    private LadderResult(final Map<User, Reward> rewardResult) {
        this.rewardResult = rewardResult;
    }

    /**
     * Value of ladder result.
     *
     * @param result the result
     * @return the ladder result
     */
    public static LadderResult valueOf(final Map<User, Reward> result) {
        return new LadderResult(result);
    }

    /**
     * Find of string.
     *
     * @param user the user
     * @return the string
     */
    public String findOf(final User user) {
        return rewardResult.entrySet()
                .stream()
                .filter(u -> u.getKey().match(user))
                .map(Map.Entry::getValue)
                .findAny()
                .map(Reward::toString)
                .orElse(GUIDE_ERR_NOT_FOUND_USER);
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<String> findAll() {
        return rewardResult.entrySet()
                .stream()
                .map(this::toString)
                .collect(Collectors.toList());
    }

    private String toString(final Map.Entry<User, Reward> userRewardEntry) {
        return String.format("%s : %s", userRewardEntry.getKey(), userRewardEntry.getValue());
    }
}
