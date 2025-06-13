import java.util.HashMap;

public class LRUCache<K, V> {
    private Node<K, V> head;
    private Node<K, V> tail;
    private HashMap<K, Node<K, V>> map;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node<>();
        this.tail = new Node<>();
        initializeDLL();
    }

    private void initializeDLL() {
        head.next = tail;
        tail.prev = head;
    }

    public void put(K key, V data) {
        if (map.containsKey(key)) {
            Node<K, V> node = map.get(key);
            node.data = data;
            moveToFront(node);
        } else {
            if (map.size() == capacity) {
                Node<K, V> lru = tail.prev;
                removeNode(lru);
                map.remove(lru.key);
            }
            Node<K, V> newNode = new Node<>(key, data);
            map.put(key, newNode);
            insertAtFront(newNode);
        }
    }

    public V get(K key) {
        if (!map.containsKey(key))
            return null;
        Node<K, V> node = map.get(key);
        moveToFront(node);
        return node.data;
    }

    private void moveToFront(Node<K, V> node) {
        removeNode(node);
        insertAtFront(node);
    }

    private void insertAtFront(Node<K, V> node) {
        Node<K, V> next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }

    private void removeNode(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void printDLL() {
        Node<K, V> current = head.next;
        while (current != tail) {
            System.out.println(current.key + ":" + current.data);
            current = current.next;
        }
    }
}
