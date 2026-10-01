import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MinimumRoadsToConnect {

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
                parent[i] = find(parent[i]); // Path compression
            }
            return parent[i];
        }

        void union(int i, int j) {
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
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        DSU dsu = new DSU(n);
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dsu.union(a, b);
        }
        
        // Find the HIGHEST index city for each component
        // We iterate from N down to 1, and if a city is the root of its component,
        // we add it to the list (if not already added).
        // To ensure we get the highest index, we can use a boolean array to track visited components.
        
        boolean[] componentVisited = new boolean[n + 1];
        List<Integer> components = new ArrayList<>();
        
        // Iterate from N down to 1 to get highest indices first
        for (int i = n; i >= 1; i--) {
            int root = dsu.find(i);
            if (!componentVisited[root]) {
                componentVisited[root] = true;
                components.add(i); // i is the highest index in this component
            }
        }
        
        // Since we iterated backwards, the list is in reverse order of discovery.
        // We want to connect the first component (highest index) to all others.
        // The first element in the list is the highest index component.
        
        int numNewRoads = components.size() - 1;
        System.out.println(numNewRoads);
        
        if (numNewRoads > 0) {
            int firstComponentRep = components.get(0);
            for (int i = 1; i < components.size(); i++) {
                System.out.println(firstComponentRep + " " + components.get(i));
            }
        }
        
        br.close();
    }
}
