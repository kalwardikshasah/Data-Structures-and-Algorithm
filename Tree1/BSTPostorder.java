import java.util.Scanner;
class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class BSTPostorder {
    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }
    public static void postOrder(Node root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        postOrder(root.left, sb);
        postOrder(root.right, sb);
        sb.append(root.data).append(" ");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            Node root = null;
            for (int i = 0; i < n; i++) {
                int val = scanner.nextInt();
                root = insert(root, val);
            }
            StringBuilder sb = new StringBuilder();
            postOrder(root, sb);
            System.out.println(sb.toString().trim());
        }
        scanner.close();
    }
}


