import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class WonderlandTokenRoads {

    static class Edge implements Comparable<Edge> {
        int u, v;
        int maxToken;

        Edge(int u, int v, int maxToken) {
            this.u = u;
            this.v = v;
            this.maxToken = maxToken;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.maxToken, other.maxToken);
        }
    }

    static class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }

        int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                if (rank[rootI] < rank[rootJ]) {
                    parent[rootI] = rootJ;
                } else if (rank[rootI] > rank[rootJ]) {
                    parent[rootJ] = rootI;
                } else {
                    parent[rootJ] = rootI;
                    rank[rootI]++;
                }
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        long[] tokenCosts = new long[k + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= k; i++) {
            tokenCosts[i] = Long.parseLong(st.nextToken());
        }
        
        List<Edge> edges = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int numTokens = Integer.parseInt(st.nextToken());
            
            int maxToken = 0;
            for (int j = 0; j < numTokens; j++) {
                if (!st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
                int token = Integer.parseInt(st.nextToken());
                if (token > maxToken) {
                    maxToken = token;
                }
            }
            
            // *** FIX: Only add edge if it connects valid cities ***
            if (u >= 1 && u <= n && v >= 1 && v <= n) {
                edges.add(new Edge(u, v, maxToken));
            }
        }
        
        Collections.sort(edges);
        
        DSU dsu = new DSU(n);
        long totalCost = 0;
        int edgesAdded = 0;
        int maxBought = 0; 
        
        for (Edge edge : edges) {
            if (dsu.union(edge.u, edge.v)) {
                if (edge.maxToken > maxBought) {
                    for (int t = maxBought + 1; t <= edge.maxToken; t++) {
                        totalCost += tokenCosts[t];
                    }
                    maxBought = edge.maxToken;
                }
                edgesAdded++;
                if (edgesAdded == n - 1) {
                    break;
                }
            }
        }
        
        if (edgesAdded < n - 1) {
            System.out.println("-1");
        } else {
            System.out.println(totalCost);
        }
        
        br.close();
    }
}