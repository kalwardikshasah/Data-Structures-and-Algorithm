import java.util.*;
public class LRUCache {
    static class Node {
        int page;
        Node prev, next;
        Node(int page) {
            this.page = page;
        }
    }
    static int capacity;
    static Node front, rear;
    static HashMap<Integer, Node> map = new HashMap<>();
    static void addFront(Node node) {
        node.next = front;
        node.prev = null;
        if (front != null)
            front.prev = node;
        else
            rear = node;

        front = node;
    }
    static void remove(Node node) {
        if (node.prev != null)
            node.prev.next = node.next;
        else
            front = node.next;

        if (node.next != null)
            node.next.prev = node.prev;
        else
            rear = node.prev;
    }
    static void access(int page) {
        if (map.containsKey(page)) {
            Node node = map.get(page);
            remove(node);
            addFront(node);
        }
        else {
            if (map.size() == capacity) {
                map.remove(rear.page);
                remove(rear);
            }
            Node node = new Node(page);
            addFront(node);
            map.put(page, node);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        capacity = sc.nextInt();
        for (int i = 0; i < n; i++) {
            access(sc.nextInt());
        }
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.page + " ");
            temp = temp.next;
        }
        sc.close();
    }
}

