package kr.seok.study;

import java.util.LinkedList;

/**
 * 유튜브에서 참고한 HashTable 구현
 * <p>
 * class
 * : Node
 * <p>
 * method
 * : constructor
 * : getHashCode(String key)
 * : convertToIndex(int hashCode)
 * : search(LinkedList<Node> list, String key)
 * : put(String key, String value)
 * : get(String key)
 */
public class YouTubeHashTable {

    LinkedList<Node>[] data;

    public YouTubeHashTable(int size) {
        this.data = new LinkedList[size];
    }

    // 해시 함수
    int getHashCode(String key) {
        int hashCode = 0;
        for (char c : key.toCharArray()) {
            hashCode += c;
        }
        return hashCode;
    }

    // 각 문자의 아스키 코드를 합쳐 넘어온 값을 length 로 나눈 나머지를 반환하는 메서드
    int convertToIndex(int hashCode) {
        return hashCode % data.length;
    }

    Node search(LinkedList<Node> list, String key) {
        if (list == null) return null;   // 노드가 저장되어 있지 않은 경우 null 반환
        for (Node node : list) {         // node 탐색
            if (node.key.equals(key)) {  // 키가 같은 노드를 찾은 경우 해당 노드를 반환
                return node;
            }
        }
        return null;                    // 노드를 찾지 못하여 null 반환
    }

    void put(String key, String value) {
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);

        LinkedList<Node> list = data[index]; // 해시 값으로 계산된 인덱스로 LinkedList 를 조회

        if (list == null) { // list가 없으면 새 LinkedList 를 생성 및 해당 인덱스에 초기화 시킴
            list = new LinkedList<>();
            data[index] = list;
        }
        // list 가 존재한다? 그럼 특정 키 값에 매핑되는 노드를 가져오도록 함
        Node node = search(list, key); // 노드 검색

        if (node == null) { // 해당 노드가 없으면 동일한 인덱스에 list 마지막에 추가
            list.addLast(new Node(key, value));
        } else { // 아니면 데이터를 수정
            node.setValue(value);
        }
    }

    String get(String key) {
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);

        LinkedList<Node> list = data[index];

        Node node = search(list, key);
        return node == null ? "not found" : node.getValue();
    }

    void dump() {
        for (LinkedList<Node> item : data) {
            if (item != null) {
                for (Node node : item) {
                    int hashCode = getHashCode(node.key);
                    System.out.println("HashCode : [" + hashCode + "] :: Index : [" + convertToIndex(hashCode) + "] :: Node : [" + node + "]");
                }
            } else {
                System.out.println("LinkedList: 비어있는 배열");
            }
        }
    }

    /**
     * String 타입의 key, value 를 관리할 수 있는 Container
     * <p>
     * 데이터를 입력하거나 조회 하는경우에 대한 setter or getter 만을 생성
     */
    static class Node {
        String key;
        private String value;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key='" + key + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }
}
