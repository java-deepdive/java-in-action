package kr.seok.study;

/**
 * @Reference [책] Do it! 자료구조와 함께 배우는 알고리즘
 *
 * @see java.util.Hashtable
 */
public class ChainHash<K, V> {

    class Node<K, V> {
        private K key;
        private V data;
        private Node<K, V> next;

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

    private int size;
    private Node<K, V>[] table;

    public ChainHash(int capacity) {
        try {
            table = new Node[capacity];
            this.size = capacity;
        } catch (OutOfMemoryError e) {
            this.size = 0;
        }
    }

    public int hashValue(Object key) {
        return key.hashCode() % size;
    }

    public V search(K key) {
        int hash = hashValue(key);
        Node<K, V> p = table[hash];

        while(p != null) {
            if(p.getKey().equals(key)) {
                return p.getValue();
            }
            p = p.next;
        }
        return null;
    }

    public int add(K key, V data) {
        int hash = hashValue(key);
        Node<K, V> p = table[hash];

        while (p != null) {
            if(p.getKey().equals(key)) {
                return 1;
            }
            p = p.next;
        }
        Node<K, V> tmp = new Node<>(key, data, table[hash]);
        table[hash] = tmp;

        return 0;
    }

    public int remove(K key) {
        int hash = hashValue(key);
        Node<K, V> p = table[hash];
        Node<K, V> pp = null;

        while (p != null) {
            if(p.getKey().equals(key)) {
                if(pp == null) {
                    table[hash] = p.next;
                } else {
                    pp.next = p.next;
                }
                return 0;
            }

            pp = p;
            p = p.next;
        }

        return 1;
    }

    public void dump() {
        for(int i = 0 ; i < size ; i++) {
            Node<K, V> p = table[i];
            System.out.printf("%02d ", i);
            while (p !=  null) {
                System.out.printf("→ %s (%s) ", p.getKey(), p.getValue());
                p = p.next;
            }
            System.out.println();
        }
    }
}
