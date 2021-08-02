package kr.seok.hash;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Hash_706 {
    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.get(1);            // returns 1
        hashMap.get(3);            // returns -1 (not found)
        hashMap.put(2, 1);          // update the existing value
        hashMap.get(2);            // returns 1
        hashMap.remove(2);          // remove the mapping for 2
        hashMap.get(2);            // returns -1 (not found)
    }

    static class Pair<K, V> {
        public K first;
        public V second;

        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    static class Bucket {
        private List<Pair<Integer, Integer>> bucket;

        public Bucket() {
            this.bucket = new LinkedList<>();
        }

        public Integer get(Integer key) {
            for (Pair<Integer, Integer> pair : this.bucket) {
                if (pair.first.equals(key))
                    return pair.second;
            }
            return -1;
        }

        public void update(Integer key, Integer value) {
            boolean found = false;
            for (Pair<Integer, Integer> pair : this.bucket) {
                if (pair.first.equals(key)) {
                    pair.second = value;
                    found = true;
                }
            }
            if (!found)
                this.bucket.add(new Pair<Integer, Integer>(key, value));
        }

        public void remove(Integer key) {
            for (Pair<Integer, Integer> pair : this.bucket) {
                if (pair.first.equals(key)) {
                    this.bucket.remove(pair);
                    break;
                }
            }
        }
    }

    static class MyHashMap {
        private int key_space;
        private List<Bucket> hash_table;

        public MyHashMap() {
            this.key_space = 2069;
            this.hash_table = new ArrayList<Bucket>();
            for (int i = 0; i < this.key_space; ++i) {
                this.hash_table.add(new Bucket());
            }
        }

        public void put(int key, int value) {
            int hash_key = getHashCode(key);
            this.hash_table.get(hash_key).update(key, value);
        }

        public int get(int key) {
            int hash_key = getHashCode(key);
            return this.hash_table.get(hash_key).get(key);
        }

        public void remove(int key) {
            int hash_key = getHashCode(key);
            this.hash_table.get(hash_key).remove(key);
        }

        private int getHashCode(int key) {
            return key % this.key_space;
        }
    }
}
