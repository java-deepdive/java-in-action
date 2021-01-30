package kr.seok._4designing;

/**
 * 인터페이스에서 default 메서드를 사용함으로써 확장할 수 있는 예시
 *
 * 다중 상속으로 인한 충돌 문제를 해결할 수 있는 예시
 *
 * 추상 클래스를 통해 인터페이스를 사용해야하는 권유사항은 지켜야하는 항목
 */
public class SeaPlane extends Vehicle implements FastFly, Sail {
    private int altitude;

    @Override
    public void cruise() {
        System.out.println("SeaPlane::cruise currently cruise like: ");
        if(altitude > 0) {
            FastFly.super.cruise();
        } else {
            Sail.super.cruise();
        }
    }

    /**
     * turn 메서드가 sail 인터페이스에도 존재하지만 Vehicle 클래스의 turn을 구현하게 된다.
     */
    @Override
    public void turn() {
        super.turn();
    }

    public static void main(String[] args) {
        SeaPlane seaPlane = new SeaPlane();
        seaPlane.takeOff();
        seaPlane.turn();
        seaPlane.cruise();
        seaPlane.land();
    }
}

interface Fly {
    default void takeOff() {
        System.out.println("Fly::takeOff");
    }
    default void land() {
        System.out.println("Fly::land");
    }
    default void turn() {
        System.out.println("Fly::turn");
    }
    default void cruise() {
        System.out.println("Fly::cruise");
    }
}

/**
 * Fly 인터페이스의 확장
 * - takeOff 메서드 오버라이딩
 * 규칙1. FastFly는 또한 Fly 인터페이스의 다른 세 개 메서드에서도 사용한다.
 * 규칙2. FastFly로부터 상속 받은 클래스와 인터페이스는 FastFly의 takeOff() 구현을 사용하며 Fly 구현을 사용하지 않는.
 */
interface FastFly extends Fly {
    @Override
    default void takeOff() {
        System.out.println("Fly::takeOff");
    }
}

interface Sail {
    default void cruise() {
        System.out.println("Sail::cruise");
    }
    default void turn() {
        System.out.println("Sail::turn");
    }
}

class Vehicle {
    public void turn() {
        System.out.println("Vehicle::turn");
    }
}
