# Java

## 개념

- final 키워드에 대한 이해

    - Immutable objects
    - Security
    - Performance
    - Java에서의 final은 Immutable/Read-only 속성을 선언하는 지시어

    - 클래스 및 생성자에서 final
        - 클래스와 메소드를 제한함으로써 Override로 인한 실수를 최소화 하고 버그를 줄이기 위해 선언

    - 함수에서 final
        - 상속되면 절대 안되는 경우 final을 정의
        - [SOLID](https://www.baeldung.com/solid-principles) 원칙 중
          하나 [ISP(Interface Segregation Principle)](https://www.baeldung.com/java-interface-segregation)

    - 변수에서 final
        - Immutable 한 값을 선언하도록 하기 위함
        - 파라미터에 선언하는 경우 메서드 내에서 값의 변경이 불가능
