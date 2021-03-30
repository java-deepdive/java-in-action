package kr.seok.movie.refactor;

import java.time.LocalDateTime;

/**
 * 영화를 예매할 책임 (INFORMATION EXPERT 패턴)
 * Reservation 인스턴스를 생성할 책임 (CREATOR 패턴)
 */
public class Screening {
    // 책임 수행을 위한 인스턴스 변수 결정
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public int getSequence() {
        return sequence;
    }

    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }

    public Reservation reserve(Customer customer, int audienceCount) { // 책임
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    public Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}
