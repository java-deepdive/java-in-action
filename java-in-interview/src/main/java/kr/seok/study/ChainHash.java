package kr.seok.study;

import java.util.HashMap;

/**
 * [책] Do it! 자료구조와 함께 배우는 알고리즘
 * <p>
 * ChainHash 구현
 * <p>
 * 해시
 * - 데이터를 저장할 위치를 간단한 연산으로 구하는 것
 * <p>
 * 해시의 구성 요소
 * - 해시 함수: key의 해시 값을 해시 테이블의 크기 size로 나눈 나머지 값을 반환
 * - 버킷: 해시 테이블의 각 요소
 * <p>
 * 충돌
 * - 저장된 버킷이 중복되는 현상
 * - 키 값과 해시 값의 대응 관계가 반드시 1:1 이라는 보증이 없음
 * <p>
 * 충돌에 대한 대처
 * 1. 체인법: 같은 해시 값을 갖는 요소를 연결 리스트를 관리
 * 2. 오픈 주소법: 빈 버킷을 찾을 때까지 해시를 반복
 * <p>
 * 체인법
 * - 해시 값을 갖는 데이터를 쇠사슬 모양으로 연결 리스트에서 연결하는 방법, 오픈 해시법이라고도 한다.
 * <p>
 * <p>
 * 충돌을 피하기 위한 해시 함수
 * - 해시 테이블 크기 이하의 정수가 되도록 한쪽으로 치우치지 않고 고르게 만들어야 한다.
 * - 그래서 해시 테이블 크기는 소수가 좋다.
 * - 키 값이 정수가 아닌 경우
 * - 실수 키 값: 비트 연산
 * - 문자열 키 값: 각 문자 코드에 곱셈과 덧셈을 하는 방법
 *
 * @see java.util.Hashtable
 * @see HashMap
 * @see java.util.concurrent.ConcurrentHashMap
 */
public class ChainHash<K, V> {

    private int size;           // 해시 테이블의 크기
    private Node<K, V>[] table; // 해시 테이블을 저장하는 배열

    // ChainHash 클래스 생성자
    public ChainHash(int capacity) {
        try {
            table = new Node[capacity];
            this.size = capacity;
        } catch (OutOfMemoryError e) {
            this.size = 0;
        }
    }

    // HashFunction
    public int hashValue(Object key) {
        return key.hashCode() % size;
    }

    // 키 값 key를 갖는 요소의 검색(데이터를 반환)
    public V search(K key) {
        int hash = hashValue(key);  // 검색할 데이터의 해시 값
        Node<K, V> p = table[hash]; // Node 배열에서 hash code를 인덱스로 검색
        /*
            1. 키 값으로 생성된 해시값
            2. 해시 값을 배열의 인덱스로 하여 Node 탐색
            3. Node의 값을 반환
         */
        while (p != null) {
            if (p.getKey().equals(key)) {
                return p.getValue();        // 검색에 성공
            }
            p = p.next;                     // 다음 노드 탐색
        }
        return null; // 해시 값에 따른 Node를 찾지 못하는 경우 null을 반환
    }

    // Node의 추가
    public int add(K key, V data) {
        int hash = hashValue(key);      // 해시값 생성
        Node<K, V> p = table[hash];     // 선택된 노드

        while (p != null) { // 해시로 검색된 노드를 키 값으로 탐색
            if (p.getKey().equals(key)) { // 동일한 키 값이 존재하는 경우 1을 반환
                return 1;
            }
            p = p.next;
        }
        /*
            새 노드를 생성하되 새로 생기는 노드를 가장 앞쪽으로 배치
         */
        Node<K, V> tmp = new Node<>(key, data, table[hash]);
        table[hash] = tmp;

        return 0;
    }

    /*
        노드 제거
        1. 해시 값 조회
        2. 포인터 값 조회
        3. 포인터를 순회하면서 키 값에 맞는 노드를 탐색
        4. 키 값이 있다? -> pp 값은 null -> 포인터의 다음 노드 주소 값을 저장하고 종료
        5. 키 값이 없다? -> 해당 포인터를 임시 포인터 값 pp 에 저장, 포인터의 다음 노드 주소값을 p에 저장 -> 키 값에 매칭되는 노드를 탐색, pp 값이 저장되어 있음 -> 포인터의 다음 노드 주소값을 pp.next에
     */
    public int remove(K key) {

        int hash = hashValue(key);  // 삭제할 데이터의 해시 값
        Node<K, V> p = table[hash]; // 선택 노드
        Node<K, V> pp = null;       // 바로 앞의 선택 노드

        while (p != null) { // 배열에서 동일한 키값의 Node를 탐색
            if (p.getKey().equals(key)) { // 키 값에 해당하는 노드 탐색 완료
                if (pp == null) {
                    table[hash] = p.next; // cur 값을 삭제 후 pointer 값을 table에 저장
                } else {
                    pp.next = p.next;
                }
                return 0;
            }
            pp = p; // key 값에 해당하는 노드가 없으면 임시 포인터에 저장
            p = p.next; // 다음 노드를 가리킴
        }
        return 1; // 해당 키 값이 존재하지 않음
    }

    public void dump() {
        for (int i = 0; i < size; i++) {
            Node<K, V> p = table[i];
            System.out.printf("%02d ", i);
            while (p != null) {
                System.out.printf("→ %s (%s) ", p.getKey(), p.getValue());
                p = p.next;
            }
            System.out.println();
        }
    }

    /**
     * 버킷용 클래스
     * - 해시를 구성하는 노드
     */
    class Node<K, V> {
        private K key;  // 키 값
        private V data; // 데이터
        private Node<K, V> next; // 다음 노드에 대한 참조

        public Node(K key, V data, Node<K, V> next) {
            this.key = key;
            this.data = data;
            this.next = next;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return data;
        }

        public int hashCode() {
            return key.hashCode();
        }
    }
}
