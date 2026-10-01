import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class PizzaToppings {

    static int n, m;
    static List<List<Integer>> adj;
    static List<List<Integer>> revAdj;
    static boolean[] visited;
    static int[] component;
    static int componentId;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        // Node mapping:
        // +x -> x - 1 (0 to m-1)
        // -x -> m + x - 1 (m to 2m-1)
        int totalNodes = 2 * m;
        adj = new ArrayList<>();
        revAdj = new ArrayList<>();
        for (int i = 0; i < totalNodes; i++) {
            adj.add(new ArrayList<>());
            revAdj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String wish1 = st.nextToken();
            int x = Integer.parseInt(st.nextToken());
            String wish2 = st.nextToken();
            int y = Integer.parseInt(st.nextToken());
            
            int node1 = getNode(wish1, x);
            int node2 = getNode(wish2, y);
            
            // Clause: (node1 OR node2)
            // Implications: (NOT node1 -> node2) and (NOT node2 -> node1)
            int notNode1 = getNegation(node1);
            int notNode2 = getNegation(node2);
            
            adj.get(notNode1).add(node2);
            revAdj.get(node2).add(notNode1);
            
            adj.get(notNode2).add(node1);
            revAdj.get(node1).add(notNode2);
        }
        
        // Kosaraju's Algorithm
        visited = new boolean[totalNodes];
        stack = new Stack<>();
        
        for (int i = 0; i < totalNodes; i++) {
            if (!visited[i]) {
                dfs1(i);
            }
        }
        
        component = new int[totalNodes];
        componentId = 0;
        visited = new boolean[totalNodes];
        
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (!visited[u]) {
                dfs2(u, componentId);
                componentId++;
            }
        }
        
        // Check for satisfiability
        boolean possible = true;
        for (int i = 1; i <= m; i++) {
            int posNode = i - 1;
            int negNode = m + i - 1;
            if (component[posNode] == component[negNode]) {
                possible = false;
                break;
            }
        }
        
        if (!possible) {
            System.out.println("IMPOSSIBLE");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= m; i++) {
                int posNode = i - 1;
                int negNode = m + i - 1;
                
                // *** FIXED LOGIC ***
                // In Kosaraju's, components are found in reverse topological order.
                // The component with the HIGHER ID comes LATER in topological order.
                // We assign TRUE to the node that comes LATER in topological order.
                if (component[posNode] > component[negNode]) {
                    sb.append("+ ");
                } else {
                    sb.append("- ");
                }
            }
            System.out.println(sb.toString().trim());
        }
        
        br.close();
    }
    
    private static int getNode(String type, int x) {
        if (type.equals("+")) {
            return x - 1; // pos(x)
        } else {
            return m + x - 1; // neg(x)
        }
    }
    
    private static int getNegation(int node) {
        if (node < m) {
            return node + m; // neg(pos(x)) = neg(x)
        } else {
            return node - m; // neg(neg(x)) = pos(x)
        }
    }
    
    private static void dfs1(int startNode) {
        Stack<int[]> dfsStack = new Stack<>();
        dfsStack.push(new int[]{startNode, 0});
        visited[startNode] = true;
        
        while (!dfsStack.isEmpty()) {
            int[] current = dfsStack.peek();
            int u = current[0];
            int idx = current[1];
            
            if (idx < adj.get(u).size()) {
                int v = adj.get(u).get(idx);
                current[1]++;
                if (!visited[v]) {
                    visited[v] = true;
                    dfsStack.push(new int[]{v, 0});
                }
            } else {
                stack.push(u);
                dfsStack.pop();
            }
        }
    }
    
    private static void dfs2(int startNode, int id) {
        Stack<Integer> dfsStack = new Stack<>();
        dfsStack.push(startNode);
        visited[startNode] = true;
        component[startNode] = id;
        
        while (!dfsStack.isEmpty()) {
            int u = dfsStack.pop();
            for (int v : revAdj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    component[v] = id;
                    dfsStack.push(v);
                }
            }
        }
    }
}
