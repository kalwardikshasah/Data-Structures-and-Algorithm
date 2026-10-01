class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SortedCircularLinkedList {

    // Function to insert a node in a sorted circular linked list
    public static Node sortedInsert(Node head_ref, int data) {
        Node new_node = new Node(data);
        Node present = head_ref;

        // Case 1: Linked list is empty
        if (head_ref == null) {
            new_node.next = new_node; // Make a self loop
            head_ref = new_node;      // Change the head pointer
            return head_ref;
        }

        // Case 2: New node insert at starting or before the head node
        // If data is smaller than head, we need to insert before head and update head
        if (data < head_ref.data) {
            // A. Find out the last node using a loop
            while (present.next != head_ref) {
                present = present.next;
            }
            // B. Change the next of last node
            present.next = new_node;
            // C. Change next of new node to point to head
            new_node.next = head_ref;
            // D. Change the head pointer to point to new node
            head_ref = new_node;
            return head_ref;
        }

        // Case 3: Insert after the head in any position
        // A. Locate the node after which new node is to be inserted
        // We stop when the next node's data is greater than the new data
        while (present.next != head_ref && present.next.data < data) {
            present = present.next;
        }

        // B. Make next of new_node as next of the located pointer
        new_node.next = present.next;

        // C. Change the next of the located pointer
        present.next = new_node;

        return head_ref;
    }

    // --- Helper methods to test the code ---

    // Helper to print the circular linked list
    public static void printList(Node head) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;

        // Testing Case 1: Empty List
        head = sortedInsert(head, 10);
        System.out.print("After inserting 10 (Empty case): ");
        printList(head);
        head = sortedInsert(head, 20);
        head = sortedInsert(head, 30);
        System.out.print("After inserting 20, 30 (Middle/End case): ");
        printList(head);
        head = sortedInsert(head, 5);
        System.out.print("After inserting 5 (Beginning case): ");
        printList(head);
        head = sortedInsert(head, 25);
        System.out.print("After inserting 25 (Middle case): ");
        printList(head);
    }
}