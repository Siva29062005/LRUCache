public class Node {
    public int key;
    public int data;
    public Node prev;
    public Node next;

    public Node(int key,int data, Node prev, Node next) {
        this.key = key;
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public Node(int key,int data) {
        this.key = key;
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public Node() {
        this.prev=null;
        this.next=null;
    }
}
