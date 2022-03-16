package kr.seok.ladder.service;


import kr.seok.ladder.domain.Height;
import kr.seok.ladder.domain.Position;
import kr.seok.ladder.domain.Reward;
import kr.seok.ladder.domain.User;
import kr.seok.ladder.generator.LineGenerator;
import kr.seok.ladder.wrapper.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * 사다리 만들어주는 Factory 클래스
 */
public final class LadderFactory {

	private LadderFactory() {
	}

	/**
	 * Value of ladder.
	 *
	 * @param participants
	 * 		참여자
	 * @param height
	 * 		높이
	 * @param generator
	 * 		사다리 만드는 알고리즘
	 * @return the ladder
	 */
	public static Ladder valueOf(
			final Participants participants, final Height height, final LineGenerator generator) {
		Line[] lines = Stream.generate(() -> generator.createLine(participants.size()))
				.limit(height.size())
				.toArray(Line[]::new);
		return Ladder.valueOf(lines);
	}

	/**
	 * Ride ladder ladder result.
	 *
	 * @param participants
	 * 		참여자
	 * @param ladder
	 * 		사다리
	 * @param ladderRewards
	 * 		보상
	 * @return the ladder result
	 */
	public static LadderResult rideLadder(
			final Participants participants, final Ladder ladder, final LadderRewards ladderRewards) {

		Map<User, Reward> result = new LinkedHashMap<>();
		Set<User> users = participants.getUsers();

		for (User user : users) {
			Position rewardPosition = ladder.findEndPosition(user.position());
			Reward reward = ladderRewards.findReward(rewardPosition);
			result.put(user, reward);
		}

		return LadderResult.valueOf(result);
	}
}
