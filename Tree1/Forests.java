import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Forests {
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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int m1 = scanner.nextInt();
            int m2 = scanner.nextInt();
            DSU mohana = new DSU(n);
            DSU john = new DSU(n);
            for (int i = 0; i < m1; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                mohana.union(u, v);
            }
            for (int i = 0; i < m2; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                john.union(u, v);
            }
            List<int[]> addedEdges = new ArrayList<>();
            for (int u = 1; u <= n; u++) {
                for (int v = u + 1; v <= n; v++) {
                    if (mohana.find(u) != mohana.find(v) && john.find(u) != john.find(v)) {
                        mohana.union(u, v);
                        john.union(u, v);
                        addedEdges.add(new int[]{u, v});
                    }
                }
            }
            System.out.println(addedEdges.size());
            for (int[] edge : addedEdges) {
                System.out.println(edge[0] + " " + edge[1]);
            }
        }
        scanner.close();
    }
}


