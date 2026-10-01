import java.util.Scanner;
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class DeleteNodesIO {
    public static Node deleteNode(Node head, int D) {
        Node dummy = new Node(-1);
        dummy.next = head;
        Node current = dummy;
        while (current.next != null) {
            if (current.next.data == D) {
                current.next = current.next.next; 
            } else {
                current = current.next; 
            }
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
                int D = scanner.nextInt();
                head = deleteNode(head, D);
            }
            printList(head);
        }        
        scanner.close();
    }
}



