import java.util.Scanner;
class Node {
    int data;
    Node prev;
    Node next;
    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
public class DoublyLinkedList {
    public static Node insertAtEnd(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = newNode;
        newNode.prev = tail;
        return head;
    }
    public static Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node current = head;
        Node temp = null;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev; 
        }
        if (temp != null) {
            head = temp.prev;
        }
        return head;
    }
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" ");
            }
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            Node head = null;
            for (int i = 0; i < n; i++) {
                if (scanner.hasNextInt()) {
                    head = insertAtEnd(head, scanner.nextInt());
                }
            }
            head = reverseList(head);
            printList(head);
            head = reverseList(head);
            printList(head);
        }
        scanner.close();
    }
}

