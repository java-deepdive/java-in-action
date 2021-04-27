package kr.seok.java8.chap5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.assertThat;

class TransactionTest {

    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    @Test
    @DisplayName("2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하기")
    void testCase1() {
        transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList())
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("거래자가 근무하는 모든 도시를 중복 없이 나열하기")
    void testCase2() {
        transactions.stream()
                // 트랜잭션과 관련한 각 거래자의 도시를 추출
                .map(transaction -> transaction.getTrader().getCity())
                // 고유한 값으로 필터링
                .distinct()
                .collect(toList())
                .forEach(System.out::println);

        transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(toSet())
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("Cambridge에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하기")
    void testCase3() {
        transactions.stream()
                // 거래자를 일단 추출
                .map(Transaction::getTrader)
                // 거래자의 근무지가 Cambridge임을 필터링
                .filter(trader -> trader.getCity().equals("Cambridge"))
                // 고유한 값들로 필터링
                .distinct()
                // 거래자의 이름을 알파뱃 순으로 정렬
                .sorted(comparing(Trader::getName))
                .collect(toList())
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("모든 거래자의 이름을 알파벳 순으로 정렬")
    void testCase4() {
        transactions.stream()
                // 거래자 추출
                .map(transaction -> transaction.getTrader().getName())
                // 거래자 중복 필터링
                .distinct()
                // 이름순으로 정렬
                .sorted()
                .collect(toList())
                .forEach(System.out::println);
        String collect = transactions.stream()
                // 거래자 추출
                .map(transaction -> transaction.getTrader().getName())
                // 거래자 중복 필터링
                .distinct()
                // 이름순으로 정렬
                .sorted()
                .collect(joining(", "));
        System.out.println(collect);
    }

    @Test
    @DisplayName("밀라노에 거래자가 있는지 여부 판단")
    void testCase5() {

        boolean isMilanTrader = transactions.stream()
                // 데이터 소스에 조건에 부합하는 요소가 있는지 확인
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));

        assertThat(isMilanTrader).isTrue();
    }


    @Test
    @DisplayName("Cambridge에 거주하는 거래자의 모든 트랜잭션 값을 출력하기")
    void testCase6() {

        transactions.stream()
                // 트랜잭션의 거래자의 도시가 Cambridge인 요소를 필터링
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                // 필터링된 거래자의 트랜잭션 값을 출력
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("전체 트랜잭션 중 최댓값은 얼마인가?")
    void testCase7() {
        transactions.stream()
                // 객체 -> 값으로 변환
                .map(Transaction::getValue)
                // 최댓값 연산
                .reduce(Integer::max)
                .ifPresent(System.out::println);
    }

    @Test
    @DisplayName("전체 트랜잭션 중 최솟값은 얼마인가?")
    void testCase8() {
        transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min)
                .ifPresent(System.out::println);
    }

}
