import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class MinimumFlightsCorrected {

    static List<List<Integer>> adj;
    static List<List<Integer>> revAdj;
    static boolean[] visited;
    static int[] component;
    static int componentId;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        adj = new ArrayList<>();
        revAdj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
            revAdj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            revAdj.get(b).add(a);
        }
        
        // --- Step 1: Find SCCs using Kosaraju's Algorithm (Iterative) ---
        visited = new boolean[n + 1];
        Stack<Integer> orderStack = new Stack<>();
        
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                iterativeDfs1(i, orderStack);
            }
        }
        
        component = new int[n + 1];
        componentId = 0;
        visited = new boolean[n + 1];
        
        while (!orderStack.isEmpty()) {
            int u = orderStack.pop();
            if (!visited[u]) {
                iterativeDfs2(u, componentId);
                componentId++;
            }
        }
        
        if (componentId == 1) {
            System.out.println("0");
            return;
        }
        
        // --- Step 2: Calculate in-degrees and out-degrees ---
        int[] inDegree = new int[componentId];
        int[] outDegree = new int[componentId];
        
        for (int u = 1; u <= n; u++) {
            for (int v : adj.get(u)) {
                if (component[u] != component[v]) {
                    outDegree[component[u]]++;
                    inDegree[component[v]]++;
                }
            }
        }
        
        // --- Step 3: Count sources and sinks ---
        int sources = 0;
        int sinks = 0;
        
        for (int i = 0; i < componentId; i++) {
            if (inDegree[i] == 0) sources++;
            if (outDegree[i] == 0) sinks++;
        }
        
        int minEdges = Math.max(sources, sinks);
        System.out.println(minEdges);
        
        // --- Step 4: Construct the edges (Corrected Logic) ---
        List<Integer> sourceNodes = new ArrayList<>();
        List<Integer> sinkNodes = new ArrayList<>();
        
        // Find a representative node for each SCC
        int[] repNode = new int[componentId];
        for (int i = 1; i <= n; i++) {
            repNode[component[i]] = i;
        }
        
        for (int i = 0; i < componentId; i++) {
            if (inDegree[i] == 0) sourceNodes.add(repNode[i]);
            if (outDegree[i] == 0) sinkNodes.add(repNode[i]);
        }
        
        // Pair sinks to sources sequentially
        int pairedCount = Math.min(sources, sinks);
        for (int i = 0; i < pairedCount; i++) {
            System.out.println(sinkNodes.get(i) + " " + sourceNodes.get(i));
        }
        
        // If there are more sinks than sources, connect the remaining sinks to the first source
        if (sinks > sources) {
            for (int i = sources; i < sinks; i++) {
                System.out.println(sinkNodes.get(i) + " " + sourceNodes.get(0));
            }
        }
        // If there are more sources than sinks, connect the first sink to the remaining sources
        else if (sources > sinks) {
            for (int i = sinks; i < sources; i++) {
                System.out.println(sinkNodes.get(0) + " " + sourceNodes.get(i));
            }
        }
        
        br.close();
    }
    
    private static void iterativeDfs1(int startNode, Stack<Integer> stack) {
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
    
    private static void iterativeDfs2(int startNode, int id) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);
        visited[startNode] = true;
        component[startNode] = id;
        
        while (!stack.isEmpty()) {
            int u = stack.pop();
            for (int v : revAdj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    component[v] = id;
                    stack.push(v);
                }
            }
        }
    }
}
