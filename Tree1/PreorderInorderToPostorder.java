import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class PreorderInorderToPostorder {
    static int[] preorder;
    static int[] inorder;
    static Map<Integer, Integer> inorderMap;
    static int preIndex = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            preorder = new int[n];
            for (int i = 0; i < n; i++) {
                preorder[i] = scanner.nextInt();
            }
            inorder = new int[n];
            inorderMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                inorder[i] = scanner.nextInt();
                inorderMap.put(inorder[i], i);
            }
            printPostorder(0, n - 1);
            System.out.println();
        }
        scanner.close();
    }
    private static void printPostorder(int inStart, int inEnd) {
        if (inStart > inEnd) {
            return;
        }
        int rootVal = preorder[preIndex++];
        int inIndex = inorderMap.get(rootVal);
        printPostorder(inStart, inIndex - 1);
        printPostorder(inIndex + 1, inEnd);
        System.out.print(rootVal + " ");
    }
}




