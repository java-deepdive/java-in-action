package kr.seok.stackNQueue;

/**
 * Do it! 자료구조와 함께 배우는 알고리즘 입문 자바 편 <br>
 *
 * 자료구조 Stack
 */
public class BookStack {
    private int max; // 스택 용량
    private int ptr; // 스택의 포인터
    private int[] stk; // 스택의 본체


    // 실행 시 예외처리: 스택이 비어 있음
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() { }
    }

    // 실행 시 예외처리: 스택이 가득 참
    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() { }
    }

    /*
        스택이 비어있으면 ptr은 0
        가득 차 있으면 max 값과 같다.
        스택 본체의 개별 요소는 바닥부터 stk[0], stk[1] ... stk[max - 1]
     */
    public BookStack(int capacity) {
        ptr = 0;
        max = capacity;
        try {
            stk = new int[max]; // 스택 본체용 배열을 생성
        } catch (OutOfMemoryError e) { // 생성할 수 없으므로 예외 처리
            max = 0;
        }
    }

    /*
        스택에 x를 푸시
        ptr은 포인터 변수를 의미하지 않으며, 새로운 데이터를 삽입할 인덱스를 기억하는 용도로 사용하는 변수이다.
        스택의 인덱스를 가리키며 스택 포인터라고 한다.

        스택이 가득 찼는지에 대한 검사는 ptr == max로 비교 가능

     */
    public int push(int x) throws OverflowIntStackException {
        if(ptr >= max) // 스택이 가득 참
            throw new OverflowIntStackException();
        // x를 저장하고 스택 포인터를 증가시킨다.
        return stk[ptr++] = x;
    }

    /*
        스택의 꼭대기에서 팝(제거) 그 값을 반환

        스택 포인터 ptr의 값을 감소시키고, stk[ptr]에 저장되어 있는 값을 반환

     */
    public int pop() throws EmptyIntStackException {
        if(ptr <= 0) // 스택이 비어 있음
            throw new EmptyIntStackException();
        return stk[--ptr];
    }

    /*
        스택이 비어 있지 않으면 stk[ptr - 1] 값을 반환

        이때 데이터의 입력과 출입이 없으므로 스택 포인터는 변화하지 않는다.

     */
    public int peek() throws EmptyIntStackException {
        if(ptr <= 0)
            throw new EmptyIntStackException();
        return stk[ptr - 1];
    }

    public int indexOf(int x) {
        for (int i = ptr - 1; i >= 0; i--) // top에서부터 선형 검색
            if (stk[i] == x)
                return i; // 검색 성공으로 인덱스 값 반환
        return -1; // 검색 실패
    }

    /*
        스택을 비움
        push 할 때 ptr 값을 하나씩 증가시키므로 0이 되면 stack이 비어있음을 표현
     */
    public void clear() {
        ptr = 0;
    }

    // 최대 수용량 확인
    public int capacity() {
        return max;
    }

    // 현재 포인터 값을 확인
    public int size() {
        return ptr;
    }

    // ptr이 0인 경우 스택이 비어있음을 정의하여 0과 비교
    public boolean isEmpty() {
        return ptr <= 0;
    }

    // max 값이 ptr과 같은 경우 스택이 가득 찼음을 판단
    public boolean isFull() {
        return ptr >= max;
    }

    public void dump() {
        if(ptr <= 0) {
            System.out.println("스택이 비어 있습니다.");
        } else {
            for(int i = 0 ; i < ptr ; i++)
                System.out.print(stk[i] + " ");
            System.out.println();
        }
    }
}
