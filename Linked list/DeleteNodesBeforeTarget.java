import java.util.Scanner;
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class DeleteNodesBeforeTarget {
    public static Node deleteNodesBefore(Node head, int target) {
        if (head == null) {
            return null;
        }
        if (head.data == target) {
            return head; 
        }
        Node current = head;
        while (current.next != null && current.next.data != target) {
            current = current.next;
        }
        if (current.next != null) {
            return current.next;
        } 
        else {
            System.out.print("Invalid Node! ");
            return head; 
        }
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
                int target = scanner.nextInt();
                head = deleteNodesBefore(head, target);
                printList(head);
            }
        }
        scanner.close();
    }
}





