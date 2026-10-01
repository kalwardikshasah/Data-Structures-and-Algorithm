import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
public class TeleporterGame {
    static class Edge {
        int to, rev;
        int cap;
        Edge(int to, int rev, int cap) {
            this.to = to;
            this.rev = rev;
            this.cap = cap;
        }
    }
    static List<List<Edge>> adj;
    static int[] level;
    static int[] ptr;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            addEdge(u, v);
        }
        int maxFlow = dinic(1, n);
        System.out.println(maxFlow);
        boolean[] visited = new boolean[n + 1];
        for (int day = 0; day < maxFlow; day++) {
            List<Integer> path = new ArrayList<>();
            findPath(1, n, path, visited);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                sb.append(path.get(i));
                if (i < path.size() - 1) sb.append(" ");
            }
            System.out.println(sb.toString());
        }
        br.close();
    }
    private static void addEdge(int u, int v) {
        adj.get(u).add(new Edge(v, adj.get(v).size(), 1));
        adj.get(v).add(new Edge(u, adj.get(u).size() - 1, 0));
    }
    private static int dinic(int s, int t) {
        int flow = 0;
        while (bfs(s, t)) {
            ptr = new int[n + 1];
            while (true) {
                int pushed = dfs(s, t, Integer.MAX_VALUE);
                if (pushed == 0) break;
                flow += pushed;
            }
        }
        return flow;
    }
    private static boolean bfs(int s, int t) {
        level = new int[n + 1];
        for (int i = 0; i <= n; i++) level[i] = -1;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        level[s] = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (Edge e : adj.get(u)) {
                if (e.cap > 0 && level[e.to] == -1) {
                    level[e.to] = level[u] + 1;
                    q.add(e.to);
                }
            }
        }
        return level[t] != -1;
    }
    private static int dfs(int u, int t, int pushed) {
        if (pushed == 0) return 0;
        if (u == t) return pushed;
        for (; ptr[u] < adj.get(u).size(); ptr[u]++) {
            Edge e = adj.get(u).get(ptr[u]);
            if (level[e.to] == level[u] + 1 && e.cap > 0) {
                int tr = dfs(e.to, t, Math.min(pushed, e.cap));
                if (tr == 0) continue;
                e.cap -= tr;
                adj.get(e.to).get(e.rev).cap += tr;
                return tr;
            }
        }
        return 0;
    }
    private static boolean findPath(int u, int t, List<Integer> path, boolean[] visited) {
        path.add(u);
        if (u == t) return true;
        visited[u] = true;
        for (Edge e : adj.get(u)) {
            if (!visited[e.to] && e.cap == 0 && e.to != u) {
                if (findPath(e.to, t, path, visited)) {
                    return true;
                }
            }
        }
        path.remove(path.size() - 1);
        return false;
    }
}


