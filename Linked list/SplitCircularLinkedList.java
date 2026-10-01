import java.util.Scanner;
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class SplitCircularLinkedList {
    public static void printCircularList(Node head) {
        if (head == null) {
            System.out.println("[h]=>[h]");
            return;
        }
        StringBuilder sb = new StringBuilder("[h]=>");
        Node temp = head;
        do {
            sb.append(temp.data).append("=>");
            temp = temp.next;
        } while (temp != head);
        sb.append("[h]");
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Complete linked_list:");
                System.out.println("[h]=>[h]");
                return;
            }
            Node head = new Node(1);
            Node current = head;
            for (int i = 2; i <= n; i++) {
                current.next = new Node(i);
                current = current.next;
            }
            current.next = head;
            System.out.println("Complete linked_list:");
            printCircularList(head);
            if (n % 2 != 0) {
                Node temp = head;
                while (temp.next.next != head) {
                    temp = temp.next;
                }
                temp.next = head; 
                n--; 
            }
            int halfSize = n / 2;
            Node firstHalf = head;
            Node mid = head;
            for (int i = 0; i < halfSize - 1; i++) {
                mid = mid.next;
            }
            Node secondHalf = mid.next;
            mid.next = firstHalf; 
            Node secondHalfTail = secondHalf;
            while (secondHalfTail.next != head) {
                secondHalfTail = secondHalfTail.next;
            }
            secondHalfTail.next = secondHalf; 
            System.out.println("Odd:");
            printCircularList(firstHalf);
            
            System.out.println("Even:");
            printCircularList(secondHalf);
        }
        scanner.close();
    }
}



