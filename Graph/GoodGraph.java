import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class GoodGraph {
    static int[] parent;
    static int[] rank;
    static int[] xorDist; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        rank = new int[n + 1];
        xorDist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int rootU = find(u);
            int rootV = find(v);
            if (rootU == rootV) {
                int cycleXor = xorDist[u] ^ xorDist[v] ^ x;
                if (cycleXor == 1) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            } else {
                union(rootU, rootV, u, v, x);
                sb.append("YES\n");
            }
        }
        System.out.print(sb.toString());
        br.close();
    }
    private static int find(int i) {
        if (parent[i] != i) {
            int root = find(parent[i]);
            xorDist[i] ^= xorDist[parent[i]];
            parent[i] = root;
        }
        return parent[i];
    }
    private static void union(int rootU, int rootV, int u, int v, int x) {
        int newXor = xorDist[u] ^ xorDist[v] ^ x;
        if (rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV;
            xorDist[rootU] = newXor;
        } else if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
            xorDist[rootV] = newXor;
        } else {
            parent[rootV] = rootU;
            xorDist[rootV] = newXor;
            rank[rootU]++;
        }
    }
}


