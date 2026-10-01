import java.util.Scanner;
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class DeleteAlternateNodes {
    public static Node deleteAlternate(Node head) {
        if (head == null) {
            return null;
        }
        Node a = head;
        while (a != null && a.next != null) {
            Node b = a.next;
            a.next = b.next;
            b = null; 
            a = a.next;
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
            Node tail = null;
            for (int i = 1; i <= n; i++) {
                Node newNode = new Node(i);
                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    tail.next = newNode;
                    tail = newNode;
                }
            }
            head = deleteAlternate(head);
            printList(head);
        }
        scanner.close();
    }
}

