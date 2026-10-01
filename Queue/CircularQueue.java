import java.util.*;
public class CircularQueue {
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
        if (front == null)
            front = rear = n;
        else {
            rear.next = n;
            rear = n;
        }
        rear.next = front;
    }
    static int dequeue() {
        if (front == null)
            return -1;
        int x = front.data;
        if (front == rear)
            front = rear = null;
        else {
            front = front.next;
            rear.next = front;
        }
        return x;
    }
    static void display() {
        if (front == null) return;
        Node t = front;
        do {
            System.out.print(t.data + " ");
            t = t.next;
        } while (t != front);
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
            enqueue(sc.nextInt());
        System.out.print("Elements in Circular Queue are:");
        display();
        System.out.println("Deleted value = " + dequeue());
        System.out.print("Deleted value = " + dequeue());
        System.out.println("Elements in Circular Queue are:");
        display();
        sc.close();
    }
}


