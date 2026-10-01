import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class TreeMatching {

    static List<List<Integer>> adj;
    static int[][] dp;
    static int[] parent;
    static int[] order;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        
        if (n <= 1) {
            System.out.println(0);
            return;
        }
        
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            // *** FIX: Ignore self-loops ***
            if (a != b) {
                adj.get(a).add(b);
                adj.get(b).add(a);
            }
        }
        
        dp = new int[n + 1][2];
        parent = new int[n + 1];
        order = new int[n];
        
        // Iterative DFS to build the order
        int idx = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        parent[1] = -1;
        
        while (!stack.isEmpty()) {
            int u = stack.pop();
            order[idx++] = u;
            for (int v : adj.get(u)) {
                if (v != parent[u]) {
                    parent[v] = u;
                    stack.push(v);
                }
            }
        }
        
        // Process nodes in reverse order (bottom-up)
        for (int i = n - 1; i >= 0; i--) {
            int u = order[i];
            
            int sumMax = 0;
            int bestGain = Integer.MIN_VALUE;
            
            for (int v : adj.get(u)) {
                if (v != parent[u]) {
                    sumMax += Math.max(dp[v][0], dp[v][1]);
                    int gain = 1 + dp[v][0] - Math.max(dp[v][0], dp[v][1]);
                    if (gain > bestGain) {
                        bestGain = gain;
                    }
                }
            }
            
            dp[u][0] = sumMax;
            dp[u][1] = sumMax + Math.max(0, bestGain);
        }
        
        System.out.println(Math.max(dp[1][0], dp[1][1]));
        br.close();
    }
}