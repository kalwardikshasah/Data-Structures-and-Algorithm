import java.util.*;
public class MaximumStamina {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] height = new long[n];
        long[] dp = new long[n];
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextLong();
        }
        int[] next = new int[n];
        Arrays.fill(next, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                next[i] = stack.peek();
            }
            stack.push(i);
        }
        long answer = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = height[i];

            if (next[i] != -1) {
                dp[i] = height[i] ^ dp[next[i]];
            }
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
        sc.close();
    }
}


