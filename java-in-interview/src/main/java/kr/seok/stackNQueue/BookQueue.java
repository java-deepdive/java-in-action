package kr.seok.stackNQueue;

/**
 * 배열 기반으로 구현된 큐
 */
public class BookQueue {
    private int max; // 큐의 용량
    private int size; // 현재의 데이터 수
    private int[] que; // 큐의 본체


    // 실행 시 예외처리: 큐가 비어 있음
    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() { }
    }

    // 실행 시 예외처리: 큐가 가득 참
    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() { }
    }

    // Queue
    public BookQueue(int capacity) {
        size = 0; // 데이터가 없는 비어있는 상태를 0으로 초기화
        max = capacity;
        try {
            que = new int[max]; // 큐 본체용 배열을 생성
        } catch (OutOfMemoryError e) {  // 생성할 수 없습니다.
            max = 0;
        }
    }

    // 큐에 데이터를 인큐
    public int enQue(int x) throws OverflowIntQueueException {
        if (size >= max) // 현재 데이터의 사이즈가 큐의 최대수용량을 넘어서는 경우 예외처리
            throw new OverflowIntQueueException(); // 큐가 가득 참
        que[size++] = x; // x를 대입 후 현재 크기를 정의하는 size 값 증가
        return x;
    }

    // 큐에서 데이터를 디큐
    public int deQue() throws EmptyIntQueueException {
        if (size <= 0) // 현재 사이즈가 0이하인 경우 예외처리
            throw new EmptyIntQueueException(); // 큐가 비어 있음
        int x = que[0]; // 맨 앞의 rear에 존재하는 요소

        for (int i = 0; i < size - 1; i++) // 앞으로 한칸 씩 앞당김 O(n)
            que[i] = que[i + 1];

        size--; // 한칸씩 당긴 후에 큐 안의 데이터 사이즈를 하나 줄임
        return x;
    }

    // 큐에서 데이터를 피크(머리 데이터를 살펴봄)
    public int peek() throws EmptyIntQueueException {
        if (size <= 0) // 현재 사이즈가 0 이하인 경우 예외처리
            throw new EmptyIntQueueException(); // 큐가 비어 있음
        return que[size - 1]; // size-- 는 size = size - 1 라서 size - 1로 처리
    }

    // 큐에서 x를 검색하여 index(찾지 못하면 -1)를 반환
    public int indexOf(int x) {
        for (int i = 0; i < size; i++)
            if (que[i] == x) // 검색성공
                return i;
        return -1; // 검색실패
    }

    // 큐를 비움
    public void clear() {
        size = 0;
    }

    // 큐의 용량을 반환
    public int capacity() {
        return max;
    }

    // 큐에 쌓인 데이터 수를 반환
    public int size() {
        return size;
    }

    // 큐가 비어 있는가?
    public boolean isEmpty() {
        return size <= 0;
    }

    // 큐가 가득 찼는가?
    public boolean isFull() {
        return size >= max;
    }

    // 큐 안의 데이터를 머리→꼬리의 차례로 출력함
    public void dump() {
        if (size <= 0)
            System.out.println("큐가 비었습니다.");
        else {
            for (int i = 0; i < size; i++)
                System.out.print(que[i] + " ");
            System.out.println();
        }
    }
}
