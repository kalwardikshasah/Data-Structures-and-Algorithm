import java.util.Scanner;
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class GetNthNodeTestCases {
    public static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    public static int getNth(Node head, int index) {
        Node current = head;
        int count = 1; 
        while (current != null) {
            if (count == index) {
                return current.data;
            }
            count++;
            current = current.next;
        }
        return -1; 
    }
    public static void printList(Node head) {
        System.out.print("Linked list:");
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
                    Node newNode = new Node(scanner.nextInt());
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
                int index = scanner.nextInt();
                head = reverseList(head);
                int result = getNth(head, index);
                printList(head);
                System.out.println("Node at index=" + index + ":" + result);
            }
        }
        scanner.close();
    }
}



