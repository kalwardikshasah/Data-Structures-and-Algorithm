import java.util.*;
public class CircularQueueLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }
    static Node front = null;
    static Node rear = null;
    static void enqueue(int value) {
        Node newNode = new Node(value);
        if (front == null) {
            front = rear = newNode;
            rear.next = front;
        } else {
            newNode.next = front;
            rear.next = newNode;
            rear = newNode;
        }
    }
    static void dequeue() {
        if (front == null)
            return;
        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
            rear.next = front;
        }
    }
    static void display() {
        if (front == null)
            return;
        Node temp = front;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != front);
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            enqueue(sc.nextInt());
        }
        display();
        dequeue();
        display();
        dequeue();
        display();
        sc.close();
    }
}

