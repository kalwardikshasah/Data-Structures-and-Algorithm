import java.util.*;
public class QueueLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int x) {
            data = x;
        }
    }
    static Node front, rear;
    static void enqueue(int x) {
        Node n = new Node(x);
        if (rear == null)
            front = rear = n;
        else {
            rear.next = n;
            rear = n;
        }
    }
    static int dequeue() {
        if (front == null)
            return -1;
        int x = front.data;
        front = front.next;
        if (front == null)
            rear = null;
        return x;
    }
    static void display() {
        for (Node t = front; t != null; t = t.next)
            System.out.print(t.data + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0)
            enqueue(sc.nextInt());
        display();
        System.out.println("Deleted value = " + dequeue());
        display();
        sc.close();
    }
}

