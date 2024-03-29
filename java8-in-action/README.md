# Java8 In Action

- 함수형 프로그래밍
- 람다, 메서드 레퍼런스, 스트림 그 외 자바 8의 새로운 내용에 대한 필요성
- 참조 투명성, 고차원 함수
- 스트림 API를 이용한 데이터를 수집하는 복잡한 질의에 대한 해법

- 스트림의 장점
    1. SQL 쿼리와 같은 복잡한 질의를 자바 문법으로 해결가능
    2. 스트림이 처리하는 데이터가 모두 메모리에 저장되어 있지 않을 수 있도록 설계되어 있어 컴퓨터 메모리에 저장할 수 없는 큰 데이터도 문제없이 처리할 수 있다.
    3. 컬렉션에서 할 수 없는 최적화를 스트림 동작에 적용가능

- 전체적인 개요
    1. 기초
    2. 함수형 데이터 처리
    3. 효과적인 자바 8 프로그래밍
    4. 자바 8의 한계를 넘어

1. 람다의 기초
    - `람다 표현식`, `메서드 레퍼런스`, `스트림`, `디폴트 메서드`
    - 개발 패턴인 동작 파라미터화
    - 람다 표현식과 메서드 레퍼런스의 이해

2. 새로운 스트림 API
    - 스트림을 이용한 데이터 컬렉션 처리법
    - 스트림의 개념과 `스트림`과 `컬렉션`의 `공통점`과 `차이점`을 설명
    - 스트림으로 복잡한 데이터 처리 질의를 표현하는 방법
    - `필터`, `슬라이싱`, `검색`, `매칭`, `매핑`, `리듀싱`
    - 스트림 API에서 제공하는 기능인 `컬렉터`
    - 스트림이 자동으로 `병렬 실행`되면서 멀티코어 아키텍처를 활용할 수 있는지, 효율적으로 병렬 스트림을 사용하는데 유의사항

3. 자바 8을 효과적으로 사용하는 방법
    - 기존코드를 개선하는 방법
    - 디자인 패턴, 리펙토링, 디버깅
    - 디폴트 메서드, 디폴트 메서드로 변화할 수 있는 API
    - 실용적인 디폴트 메서드 사용패턴, 효과적으로 디폴트 메서드를 사용하는 방법
    - Null 포인터 예외를 줄이는데 도움을 주는 `Optional` 클래스
    - 서술형으로 복잡한 비동기 동작을 표현할 수 있는, 스트림 API의 설계와 CompletableFuture
    - 새로운 날짜와 시간 API를 설명, 기존에 에러가 많이 발생했던 날짜와 시간관련 API

4. 효과적인 함수형 프로그래밍을 구현하는 방법
    - `함수형 프로그래밍`
    - 고차원 함수, 커링, 자료구조 영구 저장, 게으른 리스트, 패턴 매칭 등 고급 함수형 프로그래밍 기법
    - 자바 8과 스칼라 언어의 기능을 비교
    - 자바 8의 적극 활용 추구

## 1. Java 8을 눈여겨 봐야 하는 이유

- 간결한 코드
- 멀티코어 프로세서 환경
    - 스트림 API
    - 메서드에 코드를 전달하는 기법 (동작파라미터화: 메서드 레퍼런스, 람다) -> 함수형 프로그래밍
    - 인터페이스의 디폴트 메서드

- 함수형 프로그래밍
    - 공유되지 않은 가변데이터, 메서드와 함수 코드를 다른 메서드로 전달하는 두 가지 기능

- 패러다임 변화
    - 객체 래퍼런스 -> 메서드 레퍼런스

- 컬렉션을 필터링할 수 있는 방법
    - 컬렉션 -> 스트림
    - 병렬 처리
    - 리스트로 복원

## 2. 동작 파라미터화 코드 전달하기

- 변화하는 요구사항에 대응하기 위한 `동작 파라미터화(behavior parameterization)` 코드 전달하기
    - 인터페이스 추상화를 통한 익명 클래스 구현
    - 람다 표현식

- 컬렉션 처리 시 `데이터를 처리하는 동작`의 기본적인 종류
    - 리스트의 모든 요소에 `어떤 동작`을 수행
    - 리스트 관련 작업을 끝낸 다음에 `어떤 다른 동작`을 수행
    - 에러가 발생하면 `정해진 어떤 다른 동작`을 수행

- 동작 파라미터화 하는 방식
    - 추상적인 조건으로 필터링 하기 위한 `Predicate`를 `함수형 인터페이스로 정의`하고 `조건별 구현체`를 생성 후 동작을 전달
    - `익명 클래스`로 구현하기
    - `람다 표현식` 사용하기

## 3. 람다 표현식

- 람다 표현은 익명 함수의 일종으로 특정 표현식으로 파라미터 리스트, 바디, 반환형식을 가지며 예외를 던질 수 있다.
- 함수형 인터페이스는 하나의 추상 메서드만을 정의하는 인터페이스이다.
    - 함수형 인터페이스를 기대하는 곳에서만 람다 표현식을 사용할 수 있다.
    - 람다 표현식으로 함수형 인터페이스의 추상 메서드를 사용할 수 있으며 람다 표현식 자체가 함수형 인터페이스의 인스턴스로 취급된다.
- `함수형 인터페이스`의 `종류`에 대해서 파악하고 있어야 한다.
    - Predicate, Function, Supplier, Consumer, BinaryOperator
    - 이러한 함수형 인터페이스는 람다 표현식을 조합할 수 있는 `디폴트 메서드`를 제공한다.
- `제네릭 함수형 인터페이스`와 관련한 `박싱 동작`을 피할 수 있도록 제공하는 `기본형 특화 인터페이스`도 제공된다.
    - IntPredicate, IntToLongFunction...
- `실행 어라운드 패턴`을 람다와 활용하는 경우 유연성과 재사용성을 얻을 수 있다.
- 람다 표현식의 기대 형식을 `대상 형식`이라 한다.
- 메서드 레퍼런스를 이용하면 기존의 메서드 구현을 재사용하고 직접 전달할 수 있다.

- 람다란?
- 람다의 용도
    - 함수형 인터페이스
    - 함수 디스크립터

- 실행 어라운드 패턴
    1. 동작 파라미터화
    2. 함수형 인터페이스를 이용하여 동작 전달
    3. 동작의 실행
    4. 람다 전달
- 함수형 인터페이스 사용
    1. Predicate
    2. Consumer
    3. Function
- 형식 검사, 형식 추론, 제약
- 메서드 레퍼런스
- 람다, 메서드 레퍼런스의 활용
    1. 코드 전달
    2. 익명 클래스 사용
    3. 람다 표현식 사용
    4. 메서드 레퍼런스 사용
- 람다 표현식을 조합할 수 있는 유용한 메서드
    1. Comparator
    2. Predicate
    3. Function

## 4. 스트림 소개

- 스트림의 개발 환경 및 필요성
    - 서술형 코드를 선언형 코드로 작성하여 간결한 코드 작성 (가독성, 명확성)
    - 많은 요소를 갖는 컬렉션을 처리하기 위한 멀티코어 아키텍처와 병렬로 컬렉션의 요소를 처리하는 것을 stream에서 제공하는 api를 통해 쉽게 작성 가능

- 스트림이란?
    - 데이터 처리 연산을 지원하도록 소스에서 추출된 연속된 요소

- 스트림의 특징
    - 컬렉션과 달리 내부 반복을 지원, 컬렉션은 외부 반복
    - 내부 반복 처리를 위한 추상화 연산들이 존재함
        - filter, map, sorted

- 스트림의 구성
    - 중간 연산: 스트림을 반환하면서 다른 연산과 연결될 수 있는 연산
    - 최종 연산: 스트림 파이프라인을 처리해서 스트림이 아닌 결과를 반환하는 연산

- 스트림의 이용과정
    1. 질의를 수행할 데이터 소스
    2. 스트림 파이프라인을 구성할 중간 연산 연결
    3. 스트림 파이프라인을 실행하고 결과를 만들 최종 연산

## 5. 스트림 활용

- 요약
    - 스트림 API를 이용하면 복잡한 데이터 처리 질의를 표현할 수 있다.
    - map, flatMap 메서드로 스트림의 요소를 `추출`하거나 `변환`할 수 있다.
    - `findFirst`, `findAny` 메서드로 스트림의 요소를 검색할 수 있다.
        - `allMatch`, `noneMatch`, `anyMatch` 메서드를 이용하여 주어진 `Predicate<T>`와 일치하는 요소를 스트림에서 검색할 수 있다.
    - 위 메서드는 `쇼트서킷(short-circuit)`, 즉 `결과를 찾는 즉시 반환`하며, 전체 스트림을 처리하지 않는다.
    - `reduce` 메서드로 스트림의 모든 요소를 `반복`, `조합`하며 값을 도출할 수 있다.
        - 예를 들어 `reduce`로 스트림의 `최댓값`이나 `모든 요소의 합계`를 계산할 수 있다.
    - `filter`, `map` 등은 상태를 저장하지 않는 `상태 없는 연산(stateless operation)`
    - `reduce`, `sorted`, `distinct`는 스트림의 모든 요소(연산에 필요한 값들)를 버퍼에 저장하는 `상태 있는 연산(stateful operation)`이라 한다.
    - IntStream, DoubleStream, LongStream은 기본형 특화 스트림으로 연산은 각각의 기본형에 맞게 특화되어 있다.
    - 컬렉션 뿐아니라 값, 배열, 파일, iterate와 generate 같은 메서드로도 스트림을 만들 수 있다.
    - 크기가 정해지지 않은 스트림을 무한 스트림이라 한다.

> 스트림 활용하기

데이터를 처리하기 위해 스트림 API는 다양한 최적화 방법을 제공한다.

- 스트림의 최적화 방법
    1. 다양한 `데이터 질의`
    2. `데이터 타입`에 맞는 스트림 연산을 별도로 제공
    3. 무한 스트림

### 5.1 필터링과 슬라이싱

스트림 요소를 선택하는 방법에 대한 설명

1. 프레디케이트 필터링
2. 고유 요소 필터링
3. 스트림을 주어진 크기로 축소하는 방법
4. 스트림의 일부 요소 건너뛰기

### 5.2 매핑

특정 객체에서 특정 데이터를 선택하는 데이터 처리 작업

1. 스트림의 각 요소에 함수 적용하기
2. 스트림의 평면화

### 5.3 검색과 매칭

데이터 집합에 특정 속성이 존재하는지 여부를 검색하는 데이터 처리

1. 적어도 한 요소와 일치하는지 확인
2. 모든 요소와 일치하는 지 확인
3. 임의 요소 검색
4. 첫 번째 요소 검색

### 5.4 리듀싱

모든 스트림 요소를 처리하여 값으로 도출하는 방법

- 요소의 합, 최솟값, 최댓값을 처리

### 5.5 기본형 특화 스트림

특화 스트림은 오직 박싱 과정에서 일어나는 효율성과 관련이 있으며 스트림에 추가 기능을 제공하지 않는다.

- 스트림 API는 박싱 비용을 피할 수 있도록 int, double, long 타입에 대한 스트림을 제공한다.
- 각각의 스트림은 리듀싱 연산 수행 메서드를 제공한다.
- 필요한 경우 다시 객체 스트림으로 복원하는 기능을 제공한다.
- 숫자 범위를 이용할 수 있는 메서드를 제공한다.

### 5.6 스트림 만들기

컬렉션외에 다른 타입으로도 Stream을 얻을 수 있다.

- Stream.of()로 값을 통한 스트림 만들기
- Arrays.stream()로 배열을 통한 스트림 만들기
- Files가 제공하는 스트림 만들기
- iterate(), generate() 함수로 무한 스트림 만들기
