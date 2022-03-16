package kr.seok.racing.step3.domain;


import kr.seok.racing.step3.move.MoveStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 자동차의 생성을 관리할 클래스
 */
public class CarManager {

	private final List<Car> cars = new ArrayList<>();

	// 자동차 움직이는 전략과 함께 생성하려는 경우
	public CarManager(final String[] participants) {
		createCars(participants);
	}

	// 자동차 생성 메서드
	private void createCars(final String[] participants) {
		Arrays.stream(participants)
				.forEach(name -> cars.add(new Car(name)));
	}

	// 자동차 이동 메서드
	public RacingRound run(final MoveStrategy moveStrategy) {
		final List<Car> movedCars = cars.stream()
				.map((Car) -> Car.move(moveStrategy))
				.collect(toList());

		// 라운드 마다 새로운 객체로 생성하여 관리
		return new RacingRound(movedCars);
	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(cars);
	}
}
