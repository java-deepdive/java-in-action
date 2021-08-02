package kr.seok.stackNQueue;

import java.util.NoSuchElementException;

public class YoutubeQueue<T> {

    static class BasicQueue<T> {
        private Node<T> first;
        private Node<T> last;

        public void add(T item) {
            Node<T> t = new Node<>(item);

            // 마지막 노드를 갱신하는 경우 확인
            if (last != null) {
                last.next = t;
            }
            last = t;

            // 첫 노드가 비어있는 경우 last가 곧 first 이기 때문에 주의 해서 값을 넣어 줘야 함
            if (first == null) {
                first = last;
            }
        }

        public T remove() {
            if (first == null) throw new NoSuchElementException();

            //
            T data = first.data;
            first = first.next;

            // rear에 있는 Node가 비어있는 경우 last의 값이 있으면 안되므로 null 처리
            if (first == null) last = null;

            return data;
        }

        public T peek() {
            if (first == null) throw new NoSuchElementException();

            return first.data;
        }

        public boolean isEmpty() {
            return first == null;
        }

        static class Node<T> {
            private T data;
            private Node<T> next;

            public Node(T data) {
                this.data = data;
            }
        }
    }
}
