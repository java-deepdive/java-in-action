package kr.seok.step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 컬렉션 정보를 관리하는 레이싱 결과를 담는 클래스
 */
public class RacingResult {

    private final List<RacingRound> racingRounds;

    public RacingResult() {
        this.racingRounds = new ArrayList<>();
    }

    public void addRacingRound(final RacingRound racingRound) {
        this.racingRounds.add(racingRound);
    }

    public List<RacingRound> getRacingRounds() {
        return Collections.unmodifiableList(racingRounds);
    }

    // 레이싱 결과를 담는 클래스에 승자를 출력하기 위한 메서드
    public String[] findWinner() {
        RacingRound lastRound = getRacingRounds().get(racingRounds.size() - 1);
        List<Car> cars = lastRound.getCars();

        Position maxPosition = getMaxPosition(cars);
        return cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .map(Car::getName)
                .map(Name::getName)
                .toArray(String[]::new);
    }

    protected Position getMaxPosition(List<Car> cars) {
        return cars.stream()
                .map(Car::getPosition)
                .max(Comparator.comparingInt(Position::getPosition))
                .get();
    }
}
