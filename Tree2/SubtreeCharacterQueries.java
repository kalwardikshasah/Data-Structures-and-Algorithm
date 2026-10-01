import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class SubtreeCharacterQueries {
    static List<List<Integer>> adj;
    static char[] nodeChars;
    static int[] inTime;
    static int[] outTime;
    static int timer = 0;
    static int[][] prefix; 
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        String s = br.readLine().trim();
        nodeChars = new char[n + 1];
        for (int i = 1; i <= n; i++) {
            nodeChars[i] = s.charAt(i - 1);
        }
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        inTime = new int[n + 1];
        outTime = new int[n + 1];
        prefix = new int[26][n + 1];
        dfs(1, 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            int charIdx = c - 'a';
            int count = prefix[charIdx][outTime[u]] - prefix[charIdx][inTime[u] - 1];
            sb.append(count).append("\n");
        }
        System.out.print(sb.toString());
        br.close();
    }
    private static void dfs(int u, int parent) {
        inTime[u] = ++timer;
        for (int c = 0; c < 26; c++) {
            prefix[c][timer] = prefix[c][timer - 1];
        }
        int charIdx = nodeChars[u] - 'a';
        prefix[charIdx][timer]++;
        for (int v : adj.get(u)) {
            if (v != parent) {
                dfs(v, u);
            }
        }
        outTime[u] = timer;
    }
}



