public class Main {
    public static void main(String[] args) {
        LRUCache<Integer, Integer> lru = new LRUCache<>(3);
        lru.put(1, 10);
        lru.put(3, 15);
        lru.put(2, 12);
        System.out.println(lru.get(3));
        lru.put(4, 20);
        System.out.println(lru.get(2));
        lru.put(4, 25);
        lru.printDLL();
    }
}
