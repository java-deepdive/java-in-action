package kr.seok.tree;

import java.util.*;

public class CustomTreeMap<K, V> extends AbstractMap<K, V> {

    private final Comparator<? super K> comparator;
    private transient Entry<K, V> root;
    private transient int size = 0;
    private transient int modCount = 0;

    public CustomTreeMap() {
        comparator = null;
    }

    public CustomTreeMap(Comparator<? super K> comparator) {
        this.comparator = comparator;
    }


    public int size() {
        return size;
    }

    public boolean containsKey(Object key) {
        return getEntry(key) != null;
    }

    public V get(Object key) {
        Entry<K, V> p = getEntry(key);
        return (p == null ? null : p.value);
    }

    public Comparator<? super K> comparator() {
        return comparator;
    }

    public K firstKey() {
        return key(getFirstEntry());
    }

    public K lastKey() {
        return key(getLastEntry());
    }

    static <K> K key(Entry<K, ?> e) {
        if (e == null)
            throw new NoSuchElementException();
        return e.key;
    }

    final Entry<K, V> getFirstEntry() {
        Entry<K, V> p = root;
        if (p != null)
            while (p.left != null)
                p = p.left;
        return p;
    }

    final Entry<K, V> getLastEntry() {
        Entry<K, V> p = root;
        if (p != null)
            while (p.right != null)
                p = p.right;
        return p;
    }

    final Entry<K, V> getEntry(Object key) {
        // Offload comparator-based version for sake of performance
        if (comparator != null)
            return getEntryUsingComparator(key);
        if (key == null)
            throw new NullPointerException();
        @SuppressWarnings("unchecked")
        Comparable<? super K> k = (Comparable<? super K>) key;
        Entry<K, V> p = root;
        while (p != null) {
            int cmp = k.compareTo(p.key);
            if (cmp < 0)
                p = p.left;
            else if (cmp > 0)
                p = p.right;
            else
                return p;
        }
        return null;
    }

    final Entry<K, V> getEntryUsingComparator(Object key) {
        @SuppressWarnings("unchecked")
        K k = (K) key;
        Comparator<? super K> cpr = comparator;
        if (cpr != null) {
            Entry<K, V> p = root;
            while (p != null) {
                int cmp = cpr.compare(k, p.key);
                if (cmp < 0)
                    p = p.left;
                else if (cmp > 0)
                    p = p.right;
                else
                    return p;
            }
        }
        return null;
    }

    public V put(K key, V value) {
        Entry<K, V> t = root;
        if (t == null) {
            compare(key, key); // type (and possibly null) check

            root = new Entry<>(key, value, null);
            size = 1;
            modCount++;
            return null;
        }
        int cmp;
        Entry<K, V> parent;
        // split comparator and comparable paths
        Comparator<? super K> cpr = comparator;
        if (cpr != null) {
            do {
                parent = t;
                cmp = cpr.compare(key, t.key);
                if (cmp < 0)
                    t = t.left;
                else if (cmp > 0)
                    t = t.right;
                else
                    return t.setValue(value);
            } while (t != null);
        } else {
            if (key == null)
                throw new NullPointerException();
            @SuppressWarnings("unchecked")
            Comparable<? super K> k = (Comparable<? super K>) key;
            do {
                parent = t;
                cmp = k.compareTo(t.key);
                if (cmp < 0)
                    t = t.left;
                else if (cmp > 0)
                    t = t.right;
                else
                    return t.setValue(value);
            } while (t != null);
        }
        Entry<K, V> e = new Entry<>(key, value, parent);
        if (cmp < 0)
            parent.left = e;
        else
            parent.right = e;
        size++;
        modCount++;
        return null;
    }

    public V remove(Object key) {
        Entry<K, V> p = getEntry(key);
        if (p == null)
            return null;

        V oldValue = p.value;
        deleteEntry(p);
        return oldValue;
    }

    public Map.Entry<K, V> pollFirstEntry() {
        Entry<K, V> p = getFirstEntry();
        Map.Entry<K, V> result = exportEntry(p);
        if (p != null)
            deleteEntry(p);
        return result;
    }

    public Map.Entry<K, V> pollLastEntry() {
        Entry<K, V> p = getLastEntry();
        Map.Entry<K, V> result = exportEntry(p);
        if (p != null)
            deleteEntry(p);
        return result;
    }

    static <K, V> Map.Entry<K, V> exportEntry(Entry<K, V> e) {
        return (e == null) ? null :
                new AbstractMap.SimpleImmutableEntry<>(e);
    }

    private void deleteEntry(Entry<K, V> p) {
        modCount++;
        size--;

        // If strictly internal, copy successor's element to p and then make p
        // point to successor.
        if (p.left != null && p.right != null) {
            Entry<K, V> s = successor(p);
            p.key = s.key;
            p.value = s.value;
            p = s;
        } // p has 2 children

        // Start fixup at replacement node, if it exists.
        Entry<K, V> replacement = (p.left != null ? p.left : p.right);

        if (replacement != null) {
            // Link replacement to parent
            replacement.parent = p.parent;
            if (p.parent == null)
                root = replacement;
            else if (p == p.parent.left)
                p.parent.left = replacement;
            else
                p.parent.right = replacement;

            // Null out links so they are OK to use by fixAfterDeletion.
            p.left = p.right = p.parent = null;

        } else if (p.parent == null) { // return if we are the only node.
            root = null;
        } else { //  No children. Use self as phantom replacement and unlink.

            if (p.parent != null) {
                if (p == p.parent.left)
                    p.parent.left = null;
                else if (p == p.parent.right)
                    p.parent.right = null;
                p.parent = null;
            }
        }
    }

    static <K, V> Entry<K, V> successor(Entry<K, V> t) {
        if (t == null)
            return null;
        else if (t.right != null) {
            Entry<K, V> p = t.right;

            while (p.left != null)
                p = p.left;
            return p;
        } else {
            Entry<K, V> p = t.parent;
            Entry<K, V> ch = t;

            while (p != null && ch == p.right) {
                ch = p;
                p = p.parent;
            }
            return p;
        }
    }

    final int compare(Object k1, Object k2) {
        return comparator == null ? ((Comparable<? super K>) k1).compareTo((K) k2)
                : comparator.compare((K) k1, (K) k2);
    }

    static final class Entry<K, V> implements Map.Entry<K, V> {
        K key;
        V value;

        Entry<K, V> left;
        Entry<K, V> right;
        Entry<K, V> parent;

        Entry(K key, V value, Entry<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;

            return valEquals(key, e.getKey()) && valEquals(value, e.getValue());
        }

        public int hashCode() {
            int keyHash = (key == null ? 0 : key.hashCode());
            int valueHash = (value == null ? 0 : value.hashCode());
            return keyHash ^ valueHash;
        }

        public String toString() {
            return key + "=" + value;
        }
    }

    static final boolean valEquals(Object o1, Object o2) {
        return (o1 == null ? o2 == null : o1.equals(o2));
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return null;
    }
}
