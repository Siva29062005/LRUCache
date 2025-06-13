import java.util.HashMap;

public class LRUCache {
    private Node head;
    private Node tail;
    private HashMap<Integer, Node> map;
    private static int size = 3;

    public LRUCache() {
        this.head = new Node();
        this.tail = new Node();
        this.map = new HashMap<>();
        initializeDLL(head, tail);
    }

    public void put(int key, int data) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            deleteLRUData(node);
        }
        if (map.size() == size) {
            deleteLRUData(tail.prev);
        }
        createNewNode(key, data);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        int data = node.data;
        deleteLRUData(node);
        createNewNode(key, data);
        return data;
    }

    public void setSize(int length) {
        size = length;
    }

    private void initializeDLL(Node head, Node tail) {
        head.next = tail;
        tail.prev = head;
    }

    private void createNewNode(int key, int data) {
        Node newData = new Node(key, data);
        Node nextAfterHead = head.next;
        head.next = newData;
        newData.prev = head;
        nextAfterHead.prev = newData;
        newData.next = nextAfterHead;
        map.put(key, newData);
    }

    private void deleteLRUData(Node node) {
        Node nodeBeforeLRU = node.prev;
        nodeBeforeLRU.next = node.next;
        node.next.prev = nodeBeforeLRU;
        map.remove(node.key);
    }

    public void printDLL() {
        Node start = head.next;
        while (start.next != null) {
            System.out.println(start.key + ":" + start.data);
            start = start.next;
        }
    }
}