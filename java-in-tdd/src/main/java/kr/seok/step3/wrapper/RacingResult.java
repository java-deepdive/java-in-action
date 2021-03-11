package kr.seok.step3.wrapper;

import kr.seok.step3.domain.Car;
import kr.seok.step3.domain.Name;
import kr.seok.step3.domain.Position;

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

    // 레이싱 결과를 담는 클래스에 우승자를 배열 타입으로 반환
    public String[] findWinner() {
        List<Car> cars = getLastRound();

        Position maxPosition = getMaxPosition(cars);
        return cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .map(Car::getName).map(Name::getName)
                .toArray(String[]::new);
    }

    private List<Car> getLastRound() {
        return getRacingRounds()
                .get(racingRounds.size() - 1)
                .getCars();
    }

    // 자동차 리스트 -> Position 리스트 -> 가장 큰 값으로 반환
    protected Position getMaxPosition(List<Car> cars) {
        return cars.stream()
                .map(Car::getPosition)
                .max(Comparator.comparingInt(Position::getPosition))
                .get();
    }

    public List<RacingRound> getRacingRounds() {
        return Collections.unmodifiableList(racingRounds);
    }
}
