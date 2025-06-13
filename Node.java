public class Node<K, V> {
    public K key;
    public V data;
    public Node<K, V> prev;
    public Node<K, V> next;

    public Node(K key, V data, Node<K, V> prev, Node<K, V> next) {
        this.key = key;
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public Node(K key, V data) {
        this.key = key;
        this.data = data;
    }

    public Node() {
        this.prev = null;
        this.next = null;
    }
}
