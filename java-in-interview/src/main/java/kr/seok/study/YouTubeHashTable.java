package kr.seok.study;

import java.util.LinkedList;

/**
 * class
 *  : Node
 *
 * method
 *  : constructor
 *  : getHashCode(String key)
 *  : convertToIndex(int hashCode)
 *  : search(LinkedList<Node> list, String key)
 *  : put(String key, String value)
 *  : get(String key)
 */
public class YouTubeHashTable {

    /**
     * String 타입의 key, value 를 관리할 수 있는 Container
     *
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

    LinkedList<Node>[] data;

    public YouTubeHashTable(int size) {
        this.data = new LinkedList[size];
    }

    // 해시 함수
    int getHashCode(String key) {
        int hashCode = 0;
        for(char c : key.toCharArray()) {
            hashCode += c;
        }
        return hashCode;
    }

    // 각 문자의 아스키 코드를 합쳐 넘어온 값을 length 로 나눈 나머지를 반환하는 메서드
    int convertToIndex(int hashCode) {
        return hashCode % data.length;
    }

    Node search(LinkedList<Node> list, String key) {
        if(list == null) return null;   // 노드가 저장되어 있지 않은 경우 null 반환
        for(Node node : list) {         // node 탐색
            if(node.key.equals(key)) {  // 키가 같은 노드를 찾은 경우 해당 노드를 반환
                return node;
            }
        }
        return null;                    // 노드를 찾지 못하여 null 반환
    }

    void put(String key, String value) {
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);

        LinkedList<Node> list = data[index];

        if(list == null) {
            list = new LinkedList<>();
            data[index] = list;
        }
        Node node = search(list, key);
        if(node == null) {
            list.addLast(new Node(key, value));
        } else {
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
        for(LinkedList<Node> item : data) {
            if(item != null) {
                for(Node node : item) {
                    int hashCode = getHashCode(node.key);
                    System.out.println("HashCode : [" + hashCode + "] :: Index : [" + convertToIndex(hashCode) + "] :: Node : [" + node + "]");
                }
            } else {
                System.out.println("LinkedList: 비어있는 배열");
            }
        }
    }
}
