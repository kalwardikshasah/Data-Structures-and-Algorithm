import java.util.Scanner;
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class DeleteNNodesFromBeginning {
    public static Node deleteFromBeginning(Node head, int d) {
        Node current = head;
        for (int i = 0; i < d; i++) {
            if (current == null) {
                break; 
            }
            current = current.next;
        }
        return current;
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
                int d = scanner.nextInt();
                head = deleteFromBeginning(head, d);
                printList(head);
            }
        }
        scanner.close();
    }
}




