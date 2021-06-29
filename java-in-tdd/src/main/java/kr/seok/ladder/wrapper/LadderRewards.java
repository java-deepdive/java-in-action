package kr.seok.ladder.wrapper;


import kr.seok.ladder.domain.Position;
import kr.seok.ladder.domain.Reward;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * The type Ladder rewards.
 */
public class LadderRewards {

    private final List<Reward> rewards;

    private LadderRewards(final Reward... rewards) {
        this.rewards = Arrays.asList(rewards);
    }

    /**
     * Value of ladder rewards.
     *
     * @param ladderRewards the ladder rewards
     * @return the ladder rewards
     */
    public static LadderRewards valueOf(final Reward... ladderRewards) {
        return new LadderRewards(ladderRewards);
    }

    /**
     * Find reward reward.
     *
     * @param endPosition the end position
     * @return the reward
     */
    public Reward findReward(final Position endPosition) {
        return rewards.get(endPosition.currentPosition());
    }

    /**
     * Gets rewards.
     *
     * @return the rewards
     */
    public List<Reward> getRewards() {
        return Collections.unmodifiableList(rewards);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderRewards)) return false;
        final LadderRewards that = (LadderRewards) o;
        return Objects.equals(rewards, that.rewards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rewards);
    }

}
