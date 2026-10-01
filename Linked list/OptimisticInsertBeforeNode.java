import java.util.Scanner;
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class OptimisticInsertBeforeNode {
    public static Node insertBefore(Node head, int P, int X) {
        Node dummy = new Node(-1);
        dummy.next = head;
        Node current = dummy;
        while (current.next != null && current.next.data != P) {
            current = current.next;
        }
        if (current.next != null) {
            Node newNode = new Node(X);
            newNode.next = current.next;
            current.next = newNode;
        } else {
            System.out.println("Node not found!");
        }
        return dummy.next;
    }
    public static void printList(Node head) {
        System.out.print("Linked List:");
        Node temp = head;
        while (temp != null) {
            System.out.print("->" + temp.data);
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            Node head = null;
            Node tail = null;
            for (int i = 0; i < n; i++) {
                if (scanner.hasNextInt()) {
                    int val = scanner.nextInt();
                    Node newNode = new Node(val);
                    if (head == null) {
                        head = newNode;
                        tail = newNode;
                    } else {
                        tail.next = newNode;
                        tail = newNode;
                    }
                }
            }
            if (scanner.hasNextInt()) {
                int P = scanner.nextInt();
                if (scanner.hasNextInt()) {
                    int X = scanner.nextInt();
                    head = insertBefore(head, P, X);
                }
            }
            printList(head);
        }
        scanner.close();
    }
}

