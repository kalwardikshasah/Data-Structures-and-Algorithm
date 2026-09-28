import java.util.*;
public class StockSpan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] price = new int[n];
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
            while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - stack.peek();
            }
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(span[i] + " ");
        }
        sc.close();
    }
}

