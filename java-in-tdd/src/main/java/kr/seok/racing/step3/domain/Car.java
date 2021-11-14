package kr.seok.racing.step3.domain;


import kr.seok.racing.step3.move.MoveStrategy;

import java.util.Objects;

/**
 * 자동차의 상태와 행위를 관리하는 클래스
 */
public class Car {

    // 메시지를 처리하기 위해 자율적으로 선택
    private final Name name;
    private Position position;


    // 인터페이스를 파라미터로 받아 외부에서 움직임의 기준을 변경할 수 있도록 수정
    public Car(final String name) {
        this(new Name(name), new Position());
    }

    // 내부 및 테스트 코드에서만 호출하기위한 protected
    protected Car(final Name name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public Car move(MoveStrategy strategy) {
        if (strategy.isMovable()) {
            position = position.move();
        }
        // 이동 하면 새로 생성해야 하는게 맞을까?
        return new Car(name, position);
    }

    public boolean isWinner(final Position maxPosition) {
        return position.equals(maxPosition);
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Car car = (Car) o;
        return Objects.equals(name, car.name)
                && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
