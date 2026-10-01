import java.util.Scanner;
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class FoldLinkedList {
    public static Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; 
    }
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
    public static Node foldList(Node head) {
        if (head == null || head.next == null) return head;
        Node mid = findMiddle(head);
        Node secondHalf = mid.next;
        mid.next = null; 
        secondHalf = reverseList(secondHalf);
        Node firstHalf = head;
        while (secondHalf != null) {
            Node temp1 = firstHalf.next;
            Node temp2 = secondHalf.next;
            firstHalf.next = secondHalf;
            secondHalf.next = temp1;
            firstHalf = temp1;
            secondHalf = temp2;
        }
        return head;
    }
    public static void printList(String label, Node head) {
        System.out.print(label);
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
    public static Node cloneList(Node head) {
        if (head == null) return null;
        Node newHead = new Node(head.data);
        Node current = head.next;
        Node newCurrent = newHead;
        while (current != null) {
            newCurrent.next = new Node(current.data);
            newCurrent = newCurrent.next;
            current = current.next;
        }
        return newHead;
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
            printList("Link list data:", head);
            Node clonedHead = cloneList(head);
            Node foldedHead = foldList(clonedHead);
            printList("Link list data after fold:", foldedHead);
        }
        scanner.close();
    }
}



