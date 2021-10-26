package kr.seok.generic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BoxTest {

    @DisplayName("Casting tests between types and raw types")
    @Test
    void testCase1() {
        Box<String> stringBox = new Box<>();
        assertThat(stringBox).isInstanceOf(Box.class);
    }

    @DisplayName("Casting tests between generics with difference type parameters")
    @Test
    void testCase2() {
        Box<String> stringBox = new Box<>();
        Box<Integer> integerBox = new Box<>();

        // Cannot resolve method 'isInstanceOfAny(kr.seok.generic.Box<java.lang.Integer>)'
        // assertThat(stringBox).isInstanceOfAny(integerBox);
        // 'isEqualTo()' between objects of inconvertible types 'Box<Integer>' and 'Box<String>'
        // assertThat(stringBox).isEqualTo(integerBox);
    }

    @DisplayName("Polymorphic testing of generic types")
    @Test
    void testCase3() {
        Box<Child> childBox = new Box<>();
        Box<? extends Parent> anyChildBox = new Box<>();

        assertThat(childBox).hasSameClassAs(anyChildBox);
        assertThat(anyChildBox).hasSameClassAs(childBox);
    }

    @DisplayName("Test when the type is Object or ?(wildcard)")
    @Test
    void testCase4() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        // List<Object> 와 List<Integer> 타입은 다르기 때문에 컴파일 오류를 발생 시킨다.
//        Box.printList(list);
        // List<?> 와 List<Integer>의 경우 wildcard는 어떤 것이든 상관없이 받을 수 있기 때문에 오류를 발생시키지 않는다.
        Box.printList2(list);
    }

    @Test
    void testCase5() {

        List<Integer> list = new ArrayList();
        list.add(1);
        // 타입 안전성을 제공 한다.
        // 오버 헤드를 줄일 수 있다.
        // 확장성


        // 순서가 존재하는 데이터의 집합
    }
}