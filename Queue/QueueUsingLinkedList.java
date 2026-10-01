import java.util.*;
public class QueueUsingLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
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
    static void dequeue() {
        if (front != null)
            front = front.next;
        if (front == null)
            rear = null;
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
        dequeue();
        display();
        sc.close();
    }
}


