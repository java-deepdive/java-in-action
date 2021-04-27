---
description: 자바 기반 공부하기
---

# Contents

### Study Habit

* 좋은 학습 습관을 만들기
* 개인적인 학습 프로세스를 만들기

### [Cracking the Coding Interview](java-in-interview/README.md)

* 코딩 인터뷰 완전분석 [영문](https://www.crackingthecodinginterview.com/)
  , [번역본](https://blog.insightbook.co.kr/2017/08/07/%ec%bd%94%eb%94%a9-%ec%9d%b8%ed%84%b0%eb%b7%b0-%ec%99%84%ec%a0%84-%eb%b6%84%ec%84%9d-189%ea%b0%80%ec%a7%80-%ed%94%84%eb%a1%9c%ea%b7%b8%eb%9e%98%eb%b0%8d-%eb%ac%b8%ec%a0%9c%ec%99%80-%ed%95%b4%eb%b2%95/)
* 코딩 테스트에 대한 감이 없어서 공부
* 자료구조와 해당 자료구조에 대한 접근법\(알고리즘\)을 차근차근 공부하면 좋아보임
* 코딩 테스트 연습을 할 수 있는 사이트와 병행하는 것이 좋을 듯

### [Java In LeetCode](https://github.com/SeokRae/java-in-action/tree/4210c572ea2f967a663f57a09f5e4c2f1099a375/java-in-leetCode/README.md)

* [LeetCode](https://leetcode.com/)
	* 알고리즘 분류 별로 정리
	* 알고리즘의 핵심적인 접근 방법에 대한 내용이 많음
	* Cracking the Coding Interview 내용 안에 같은 유형이 많음

	  **Initial page**

### [Java8 In Functional](https://github.com/SeokRae/java-in-action/tree/4210c572ea2f967a663f57a09f5e4c2f1099a375/java8-in-functional/README.md)

* 서술적인 내용이 아닌 함축적인 내용으로 쉽게 이해하기 힘들고 예제 코드도 부족함
* 빠르게 훑어보고 어떤 것이 있는지, 내게 필요한 부분이 어떤 것이 있는지 확인하는 용도로 써야 할 듯

### [Java8 In Action](https://github.com/SeokRae/java-in-action/tree/4210c572ea2f967a663f57a09f5e4c2f1099a375/java8-in-action/README.md)

* Java8을 본격 공부하기 위한 책
* 단순하게 코딩하기 위해서가 아니라 Java8에서 구현된 코드의 매커니즘을 공부해야 함
* Java 8이 나오게 된 개발 환경, 상황적인 부분을 고려하여 이해 할 것

### [기술이론 정리하기](https://www.notion.so/seokrae/b231ac0ef6cd406d9db051cf08050c58)

1. JPA
2. RDB
3. Design Pattern & HTTP, REST API

### [TDD, Clean Code with Java 11기](java-in-tdd/README.md)

* nextstep 의 TDD, Clean Code with Java 11기 진행
* TDD, OOP 관점에 대한 이해
* 개발 자유도가 높아 구조적인 것 외에는 코드가 다 다를 수 있음

#### JUnit 학습 테스트

* JUnit 연습
	* @DisplayName
	* @ParameterizedTest
	* @CsvSource
	* @MethodSource
	* @ValueSource
	* assertThatIllegalArgumentException\(\)
	* assertThatIllegalStateException\(\)
	* assertThatIOException\(\)
	* assertThatNullPointerException\(\)

#### 단순한 로직으로 OOP 패턴 구현하기

* 메서드의 분리
* TDD 실습 및 습관화를 위한 연습

#### 자동차 경주

* 경험해야할 학습 목표
	* Github 기반으로 온라인 코드 리뷰하는 경험
	* JUnit 사용법을 익혀 단위 테스트하는 경험
	* 자바 code convention을 지키면서 프로그래밍하는 경험
	* 메소드를 분리하는 리팩토링 경험
* 경험할 객체지향 생활 체조 원칙
	* 규칙 1: 한 메서드에 오직 한 단계의 들여쓰기만 한다.
	* 규칙 2: else 예약어를 쓰지 않는다.
	* 이 두가지 원칙을 통해 메소드를 분리해 메소드가 한 가지 작업만 담당하도록 구현하는 연습을 목표로 한다.
	* 이 같은 원칙 아래에서 메소드의 라인 수를 15라인이 넘지 않도록 구현한다.

#### 로또

* 경험해야할 학습 목표
	* TDD 기반으로 프로그래밍하는 경험
	* 메소드 분리 + 클래스를 분리하는 리팩토링 경험
	* 점진적으로 리팩토링하는 경험
* 경험할 객체지향 생활 체조 원칙
	* 규칙 1: 한 메서드에 오직 한 단계의 들여쓰기만 한다.
	* 규칙 2: else 예약어를 쓰지 않는다.
	* 규칙 3: 모든 원시값과 문자열을 포장한다.
	* 규칙 5: 줄여쓰지 않는다\(축약 금지\).
	* 규칙 8: 일급 콜렉션을 쓴다.

#### **사다리타기 - FP, OOP**

* 경험해야할 학습 목표
	* 자바8의 스트림, 람다를 사용해 함수형 프로그래밍하는 경험
	* In -&gt; Out, Out -&gt; In 방식으로 도메인 객체를 설계하는 경험
	* 책임주도설계 기반으로 인터페이스 활용해 프로그래밍하는 연습
* 경험할 객체지향 생활 체조 원칙
	* 규칙 4: 한 줄에 점을 하나만 찍는다.
	* Clean Code 가이드의 디미터 법칙을 지키는 것을 의미한다.
	* 규칙 6: 모든 엔티티를 작게 유지한다.
	* 규칙 7: 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
	* 규칙 9: 게터/세터/프로퍼티를 쓰지 않는다.

#### 참고

* Git Commit
	* [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)
	* [Code Convention](https://google.github.io/styleguide/javaguide.html)

### keyword

* KPI
* MBO
