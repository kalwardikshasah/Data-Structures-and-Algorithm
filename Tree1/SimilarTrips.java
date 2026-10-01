import java.util.*;
public class SimilarTrips {
    static List<List<Integer>> adj;
    static Set<String> distinctTrips;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            adj = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < n - 1; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            distinctTrips = new HashSet<>();
            dfs(1, 0, new StringBuilder());
            System.out.println(distinctTrips.size());
        }
        scanner.close();
    }
    private static void dfs(int u, int parent, StringBuilder path) {
        path.append(adj.get(u).size()).append(",");
        distinctTrips.add(path.toString());
        for (int v : adj.get(u)) {
            if (v != parent) {
                dfs(v, u, path);
            }
        }
        int lastComma = path.lastIndexOf(",");
        if (lastComma != -1) {
            path.setLength(lastComma);
        }
    }
}



